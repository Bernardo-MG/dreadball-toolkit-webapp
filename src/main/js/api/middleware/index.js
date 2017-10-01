
const actionWith = (action, key) => (data) => {
   const finalAction = Object.assign({}, action, data);

   delete finalAction[key];

   return finalAction;
};

const appendBase = (url) => {
   let result;

   if (url.indexOf(ROUTE_BASE) === -1) {
      result = ROUTE_BASE + url;
   } else {
      result = url;
   }

   return result;
};

const getParams = (content) => {
   let { params } = content;
   const { page, orderBy, direction } = content;

   if (!params) {
      params = {};
   }

   return {
      ...params,
      page,
      orderBy,
      direction
   };
};

const middleware = (next, action, fetch, key) => {
   const callAPI = action[key];

   if (typeof callAPI === 'undefined') {
      return next(action);
   }

   const params = getParams(callAPI);

   let { parse } = callAPI;
   const { endpoint, types } = callAPI;

   if (!parse) {
      parse = (json) => json;
   }
   if (typeof endpoint !== 'string') {
      throw new Error('Specify a string endpoint URL.');
   }
   if (!Array.isArray(types) || types.length !== 3) {
      throw new Error('Expected an array of three action types.');
   }
   if (!types.every((type) => typeof type === 'string')) {
      throw new Error('Expected action types to be strings.');
   }

   const processAction = actionWith(action, key);
   const [requestType, successType, failureType] = types;

   next(processAction({ type: requestType }));

   const url = appendBase(endpoint);

   return fetch(url, params, parse).then(
      (response) => next(processAction({
         type: successType,
         ...response
      })),
      (error) => next(processAction({
         type: failureType,
         error: error.message || 'Something bad happened'
      }))
   );
};

export default middleware;

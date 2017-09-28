import { CALL_API_STATUS } from 'fetch/actions/ActionTypes';

const actionWith = (action) => (data) => {
   const finalAction = Object.assign({}, action, data);

   delete finalAction[CALL_API_STATUS];

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

const middleware = (next, action, getParams, fetch, key) => {
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

   const processAction = actionWith(action);
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

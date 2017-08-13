import { CALL_API_STATUS } from 'fetch/actions/ActionTypes';
import { getUrl } from 'fetch/url';

const actionWith = (action) => (data) => {
   const finalAction = Object.assign({}, action, data);

   delete finalAction[CALL_API_STATUS];

   return finalAction;
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

   const urlParams = { ...params };
   const url = getUrl(endpoint, urlParams);

   return fetch(url, parse).then(
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

import { CALL_API_STATUS } from 'fetch/actions/ActionTypes';
import { fetchStatus } from 'fetch';
import { getUrl } from 'fetch/url';

const callApi = (url, parse) => fetchStatus(url, parse);

const actionWith = (action) => (data) => {
   const finalAction = Object.assign({}, action, data);

   delete finalAction[CALL_API_STATUS];

   return finalAction;
};

// A Redux middleware that interprets actions with CALL_API_STATUS info specified.
// Performs the call and promises when such actions are dispatched.
export default () => (next) => (action) => {
   const callAPI = action[CALL_API_STATUS];

   if (typeof callAPI === 'undefined') {
      return next(action);
   }

   let { parse, params } = callAPI;
   const { endpoint, types, page, orderBy, order } = callAPI;

   if (!parse) {
      parse = (json) => json;
   }
   if (!params) {
      params = {};
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

   const urlParams = { orderBy, order, page, ...params };
   const url = getUrl(endpoint, urlParams);

   return callApi(url, parse).then(
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

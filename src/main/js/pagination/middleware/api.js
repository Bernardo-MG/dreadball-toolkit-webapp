import { CALL_API } from 'pagination/actions/ActionTypes';
import { fetchPaginated } from 'pagination/fetch';
import { getUrl } from 'pagination/url';

// A Redux middleware that interprets actions with CALL_API info specified.
// Performs the call and promises when such actions are dispatched.
export default store => (next) => (action) => {
   const callAPI = action[CALL_API];

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
   )
}

const callApi = (url, parse) => fetchPaginated(url, parse);

const actionWith = (action) => (data) => {
   const finalAction = Object.assign({}, action, data);

   delete finalAction[CALL_API];

   return finalAction;
};

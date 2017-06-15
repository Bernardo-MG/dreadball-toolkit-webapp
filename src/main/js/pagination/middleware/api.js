import { CALL_API } from 'pagination/actions/ActionTypes';
import { fetchPaginated } from 'pagination/fetch';

// A Redux middleware that interprets actions with CALL_API info specified.
// Performs the call and promises when such actions are dispatched.
export default store => (next) => (action) => {
   const callAPI = action[CALL_API];

   if (typeof callAPI === 'undefined') {
      return next(action);
   }

   let { endpoint, parse } = callAPI;
   const { types, page, orderBy, order } = callAPI;

   if (typeof endpoint === 'function') {
      endpoint = endpoint(store.getState());
   }

   if (typeof parse !== 'function') {
      parse = (json) => json;
   }
   if (typeof endpoint !== 'string') {
      throw new Error('Specify a string endpoint URL.');
   }
   if (!Array.isArray(types) || types.length !== 3) {
      throw new Error('Expected an array of three action types.');
   }
   if (!types.every(type => typeof type === 'string')) {
      throw new Error('Expected action types to be strings.');
   }

   const processAction = actionWith(action)
   const [ requestType, successType, failureType ] = types

   next(processAction({ type: requestType }))

   return callApi(endpoint, page, parse, orderBy, order).then(
      response => next(processAction({
         type: successType,
         ...response
      })),
      error => next(processAction({
         type: failureType,
         error: error.message || 'Something bad happened'
      }))
   )
}

const callApi = (endpoint, page, parse, orderBy, order) => {
   const localEndpoint = appendBase(endpoint);
   const url = paginateUrl(localEndpoint, page, orderBy, order)
   
   return fetchPaginated(url, parse);
}

const actionWith = (action) => (data) => {
   const finalAction = Object.assign({}, action, data)

   delete finalAction[CALL_API]

   return finalAction
}

const appendBase = (url) => {
   if(url.indexOf(ROUTE_BASE) === -1) {
      return ROUTE_BASE + url
   } else {
      return url
   }
}

const paginateUrl = (url, page, orderBy, order) => {
   let result = url;
   let params = '';

   // Page params
   if(page){
      params = params + 'page=' + page;
   }

   // Order by params
   if(orderBy){
      if(params){
         params = params + '&&';
      }
      params = params + 'orderBy=' + orderBy + '&&' + 'order=' + order;
   }

   // Params are added to the URL
   if(params){
      result = result + '?' + params;
   }

   return result;
}

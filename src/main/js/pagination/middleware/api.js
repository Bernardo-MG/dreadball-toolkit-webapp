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

   if (!parse) {
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

   const urlParams = { orderBy, order, page };
   
   const url = getUrl(endpoint, urlParams);

   return callApi(url, parse).then(
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

const getUrl = (endpoint, params) => {
   const localEndpoint = appendBase(endpoint);
   const url = applyParams(localEndpoint, params)

   return url;
}

const callApi = (url, parse) => {
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

const applyParams = (url, params) => {
   let result = url;
   let urlParams = '';

   // Page params
   urlParams = paginationParams(urlParams, params.page);

   // Ordering params
   urlParams = orderByParams(urlParams, params.orderBy, params.order);

   // Params are added to the URL
   if(urlParams){
      result = result + '?' + urlParams;
   }

   return result;
}

const paginationParams = (params, page) => {
   if(page){
      if(params){
         params = params + '&&';
      }
      params = params + 'page=' + page;
   }
}

const orderByParams = (params, orderBy, order) => {
   if(orderBy){
      if(params){
         params = params + '&&';
      }
      params = params + 'orderBy=' + orderBy + '&&' + 'order=' + order;
   }
}

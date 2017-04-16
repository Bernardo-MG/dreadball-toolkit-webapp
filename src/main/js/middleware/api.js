import { CALL_API } from 'actions/ActionTypes'

// A Redux middleware that interprets actions with CALL_API info specified.
// Performs the call and promises when such actions are dispatched.
export default store => next => action => {
   const callAPI = action[CALL_API]
   
   if (typeof callAPI === 'undefined') {
      return next(action)
   }
   
   let { endpoint, acquirePage } = callAPI
   const { types, parse } = callAPI
   
   if (typeof endpoint === 'function') {
      endpoint = endpoint(store.getState())
   }
   
   if (typeof parse !== 'function') {
      throw new Error('Specify a json parsing function.')
   }
   if (typeof endpoint !== 'string') {
      throw new Error('Specify a string endpoint URL.')
   }
   if (!Array.isArray(types) || types.length !== 3) {
      throw new Error('Expected an array of three action types.')
   }
   if (!types.every(type => typeof type === 'string')) {
      throw new Error('Expected action types to be strings.')
   }
   
   if (typeof acquirePage === 'undefined') {
      acquirePage = initialPage
   }
   
   let page = acquirePage(store.getState());
   
   const processAction = actionWith(action)
   const [ requestType, successType, failureType ] = types
   
   next(processAction({ type: requestType }))
   
   return callApi(endpoint, page, parse).then(
      response => next(processAction({
         type: successType,
         payload: response
      })),
      error => next(processAction({
         type: failureType,
         error: error.message || 'Something bad happened'
      }))
   )
}

const callApi = (endpoint, page, parse) => {
   const url = paginatedUrl(fullUrl(endpoint), page)
   
   return fetch(url)
      .then(response =>
         response.json().then(json => {
            if (!response.ok) {
               return Promise.reject(json)
            }
            
            return parse(json)
         })
      )
}

const actionWith = action => data => {
   const finalAction = Object.assign({}, action, data)
   
   delete finalAction[CALL_API]
   
   return finalAction
}

const fullUrl = url => {
   if(url.indexOf(ROUTE_BASE) === -1) {
      return ROUTE_BASE + url
   } else {
      return url
   }
}

const paginatedUrl = (url, page) => {
   return url + '?page=' + page
}

const initialPage = (state) => {
   return 0
}

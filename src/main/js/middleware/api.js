import { CALL_API } from 'actions/ActionTypes'

// A Redux middleware that interprets actions with CALL_API info specified.
// Performs the call and promises when such actions are dispatched.
export default store => next => action => {
   const callAPI = action[CALL_API]
   
   if (typeof callAPI === 'undefined') {
      return next(action)
   }
   
   let { endpoint } = callAPI
   const { types, parse, page } = callAPI
   
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
   
   const processAction = actionWith(action)
   const [ requestType, successType, failureType ] = types
   
   next(processAction({ type: requestType }))
   
   return callApi(endpoint, page, parse).then(
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

const callApi = (endpoint, page, parse) => {
   const url = paginatedUrl(fullUrl(endpoint), page)
   
   return fetch(url)
      .then(response =>
         response.json().then(json => {
            if (!response.ok) {
               return Promise.reject(json)
            }
            
            return parsePaginated(json, parse)
         })
      )
}

const parsePaginated = (json, parse) => {
   const payload = parse(json.content)
   
   return { payload: payload,
            page: json.number,
            first: json.first,
            last: json.last,
            elements: payload.length,
            totalPages: json.totalPages,
            totalElements: json.totalElements }
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

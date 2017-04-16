import union from 'lodash/union'

// Creates a reducer managing pagination, given the action types to handle,
// and a function telling how to extract the key from an action.
const paginate = ({ types }) => {
   if (!Array.isArray(types) || types.length !== 3) {
      throw new Error('Expected types to be an array of three elements.')
   }
   if (!types.every(t => typeof t === 'string')) {
      throw new Error('Expected types to be strings.')
   }
   
   const [ requestType, successType, failureType ] = types
   
   return (state = {
         isFetching: false,
         nextPageUrl: undefined,
         pageCount: 0,
         ids: []
      }, action) => {
      // Update pagination by key
      const { type } = action
      switch (type) {
         case requestType:
         case successType:
         case failureType:
            return updatePagination(state, action, requestType, successType, failureType)
         default:
            return state
      }
   }
}

const updatePagination = (state, action, requestType, successType, failureType) => {
   const { type, payload, nextPageUrl } = action
   switch (type) {
      case requestType:
         return {
               ...state,
               isFetching: true
            }
      case successType:
         return {
               ...state,
               isFetching: false,
               ids: union(state.ids, payload),
               nextPageUrl: nextPageUrl,
               pageCount: state.pageCount + 1
            }
      case failureType:
         return {
               ...state,
               isFetching: false
            }
      default:
         return state
   }
}

export default paginate
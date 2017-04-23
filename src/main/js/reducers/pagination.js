import union from 'lodash/union'

// Creates a reducer managing pagination, given the action types to handle,
// and a function telling how to extract the key from an action.
const paginate = ({ idsMapping, types }) => {
   if (!Array.isArray(types) || types.length !== 3) {
      throw new Error('Expected types to be an array of three elements.')
   }
   if (!types.every(t => typeof t === 'string')) {
      throw new Error('Expected types to be strings.')
   }
   
   const [ requestType, successType, failureType ] = types
   
   return (state = {
         isFetching: false,
         page: 0,
         totalPages: 0,
         totalElements: 0,
         ids: []
      }, action) => {
      // Update pagination by key
      const { type } = action
      switch (type) {
         case requestType:
         case successType:
         case failureType:
            return updatePagination(state, action, idsMapping, requestType, successType, failureType)
         default:
            return state
      }
   }
}

const updatePagination = (state, action, idsMapping, requestType, successType, failureType) => {
   const { type, payload, page, elements, totalPages, totalElements } = action
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
               ids: union(state.ids, idsMapping(payload)),
               page: page,
               elements: elements,
               totalPages: totalPages,
               totalElements: totalElements
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
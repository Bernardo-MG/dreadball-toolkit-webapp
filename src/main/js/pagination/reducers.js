import union from 'lodash/union';

const updatePagination = (state, action, idsMapping, requestType, successType, failureType, clearType) => {
   const { type, payload } = action;

   switch (type) {
   case requestType:
      return {
         ...state,
         isFetching: true
      };
   case successType: {
      let pagination = action.pagination;

      if (!pagination) {
         pagination = {};
      }

      return {
         ...state,
         ...pagination,
         isFetching: false,
         ids: union(state.ids, idsMapping(payload))
      };
   }
   case failureType:
      return {
         ...state,
         isFetching: false
      };
   case clearType:
      return {
         ...state,
         ids: [],
         isFetching: false
      };
   default:
      return state;
   }
};

// Creates a reducer managing pagination, given the action types to handle,
// and a function telling how to extract the key from an action.
const paginate = ({ idsMapping, types }) => {
   const [requestType, successType, failureType, clearType] = types;

   return (state = { isFetching: false, ids: [], first: true, last: true, numberOfElements: 0, totalElements: 0, page: 0, totalPages: 0 }, action) =>
      updatePagination(state, action, idsMapping, requestType, successType, failureType, clearType);
};

export default paginate;

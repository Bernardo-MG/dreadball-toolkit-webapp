import union from 'lodash/union';

const updatePagination = (state, action, idsMapping, requestType, successType, failureType) => {
   const { type, payload } = action;

   switch (type) {
   case requestType:
      return {
         ...state,
         isFetching: true
      };
   case successType: {
      return {
         ...state,
         isFetching: false,
         ids: union(state.ids, idsMapping(payload))
      };
   }
   case failureType:
      return {
         ...state,
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

   return (state = { isFetching: false, ids: [] }, action) =>
      updatePagination(state, action, idsMapping, requestType, successType, failureType, clearType);
};

export default paginate;

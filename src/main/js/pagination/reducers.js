import union from 'lodash/union';
import { CALL_API_PAGINATED } from 'pagination/actions/ActionTypes';

const updatePagination = (state, action, idsMapping, requestType, successType, failureType) => {
   const { type, payload } = action;
   const callApi = action[CALL_API_PAGINATED];

   let replace = false;
   if (callApi) {
      replace = callApi.replace;
   }

   switch (type) {
   case requestType:
      return {
         ...state,
         isFetching: true
      };
   case successType: {
      let pagination = action.pagination;
      let ids;

      if (!pagination) {
         pagination = {};
      }

      if (replace) {
         ids = idsMapping(payload);
      } else {
         ids = union(state.ids, idsMapping(payload));
      }

      return {
         ...state,
         ...pagination,
         isFetching: false,
         ids
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
   const [requestType, successType, failureType] = types;

   return (state = { isFetching: false, ids: [], first: true, last: true, numberOfElements: 0, totalElements: 0, page: 0, totalPages: 0 }, action) =>
      updatePagination(state, action, idsMapping, requestType, successType, failureType);
};

export default paginate;

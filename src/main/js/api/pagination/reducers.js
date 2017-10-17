import union from 'lodash/union';
import { CALL_API, REQUEST, REQUEST_SUCCESS, REQUEST_FAILURE, CHANGE_PAGE } from 'api/ActionTypes';

const updatePagination = (state, action, idsMapping, store) => {
   const { type, payload } = action;
   const callApi = action[CALL_API];
   const requestType = `${REQUEST}_${store}`;
   const successType = `${REQUEST_SUCCESS}_${store}`;
   const failureType = `${REQUEST_FAILURE}_${store}`;
   const prevType = `${CHANGE_PAGE}_PREV_${store}`;
   const nextType = `${CHANGE_PAGE}_NEXT_${store}`;

   let replace = false;
   if (callApi) {
      replace = callApi.replace;
   }
   let page = state.page;

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
   case prevType:
      if (!state.first) {
         page -= 1;
      }

      return {
         ...state,
         page
      };
   case nextType:
      if (!state.last) {
         page += 1;
      }

      return {
         ...state,
         page
      };
   default:
      return state;
   }
};

// Creates a reducer managing pagination, given the action types to handle,
// and a function telling how to extract the key from an action.
const paginate = ({ idsMapping, store }) =>
   (state = { isFetching: false, ids: [], first: true, last: true, numberOfElements: 0, totalElements: 0, page: 0, totalPages: 0 }, action) =>
      updatePagination(state, action, idsMapping, store);

export default paginate;

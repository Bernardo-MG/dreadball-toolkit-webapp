import union from 'lodash/union';

const updatePagination = (state, action, idsMapping, store) => {
   const { type, payload } = action;
   const requestType = `REQUEST_${store}`;
   const successType = `REQUEST_SUCCESS_${store}`;
   const failureType = `REQUEST_FAILURE_${store}`;
   const prevType = `CHANGE_PAGE_PREV_${store}`;
   const nextType = `CHANGE_PAGE_NEXT_${store}`;

   let replace = false;
   if (action.replace) {
      replace = action.replace;
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

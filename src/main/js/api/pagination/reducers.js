import union from 'lodash/union';

const updatePagination = (state, action, idsMapping, store) => {
   const { type, payload } = action;
   const successType = `REQUEST_SUCCESS_${store}`;
   const failureType = `REQUEST_FAILURE_${store}`;
   const fetchingType = `FETCHING_${store}`;

   const { replace } = action;

   switch (type) {
   case fetchingType:
      return {
         ...state,
         isFetching: true
      };
   case successType: {
      let { pagination } = action;
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
const paginate = ({ idsMapping, store }) =>
   (state = { isFetching: false, ids: [], first: true, last: false, numberOfElements: 0, totalElements: 0, page: 0, totalPages: 0 }, action) =>
      updatePagination(state, action, idsMapping, store);

export default paginate;

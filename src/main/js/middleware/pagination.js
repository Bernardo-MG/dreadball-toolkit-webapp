import { CALL_API_PAGINATED } from 'pagination/actions/ActionTypes';
import { fetchPaginated } from 'pagination/fetch';
import middleware from 'fetch/middleware';

const getParams = (content) => {
   let { params } = content;
   const { page, orderBy, order } = content;

   if (!params) {
      params = {};
   }

   return {
      ...params,
      page,
      orderBy,
      order
   };
};

// A Redux middleware that interprets actions with CALL_API_PAGINATED info specified.
// Performs the call and promises when such actions are dispatched.
export default () => (next) => (action) => {
   middleware(next, action, getParams, fetchPaginated, CALL_API_PAGINATED);
};

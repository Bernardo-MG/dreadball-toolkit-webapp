import { CHANGE_PAGE } from 'api/ActionTypes';

export const movePage = (fetch) => {
   return {
      type: CHANGE_PAGE,
      fetch
   };
};

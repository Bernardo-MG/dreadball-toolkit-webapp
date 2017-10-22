import { CALL_API, CHANGE_PAGE } from 'api/ActionTypes';

export const callApi = (data = {}) => {
   return {
      [CALL_API]: {
         ...data
      }
   };
};

export const previousPage = (data = {}) => {
   return {
      type: CHANGE_PAGE,
      direction: 'PREV',
      ...data
   };
};

export const nextPage = (data = {}) => {
   return {
      type: CHANGE_PAGE,
      direction: 'NEXT',
      ...data
   };
};

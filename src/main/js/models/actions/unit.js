import { REQUEST_UNITS, CHANGE_PAGE_PREV_UNITS, CHANGE_PAGE_NEXT_UNITS, REQUEST_SUCCESS_UNITS } from 'models/actions/actionTypes';

export const fetch = () => {
   return {
      type: REQUEST_UNITS
   };
};

export const movePrevPage = () => {
   return {
      type: CHANGE_PAGE_PREV_UNITS
   };
};

export const moveNextPage = () => {
   return {
      type: CHANGE_PAGE_NEXT_UNITS
   };
};

export const requestSuccess = (payload, pagination) => {
   return {
      type: REQUEST_SUCCESS_UNITS,
      payload,
      pagination
   };
};

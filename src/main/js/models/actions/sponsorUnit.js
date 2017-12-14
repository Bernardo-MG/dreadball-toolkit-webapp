import { REQUEST_SPONSOR_UNITS, CHANGE_PAGE_PREV_SPONSOR_UNITS, CHANGE_PAGE_NEXT_SPONSOR_UNITS, REQUEST_SUCCESS_SPONSOR_UNITS } from 'models/actions/ActionTypes';

export const fetch = () => {
   return {
      type: REQUEST_SPONSOR_UNITS
   };
};

export const movePrevPage = () => {
   return {
      type: CHANGE_PAGE_PREV_SPONSOR_UNITS
   };
};

export const moveNextPage = () => {
   return {
      type: CHANGE_PAGE_NEXT_SPONSOR_UNITS
   };
};

export const requestSuccess = (payload, pagination) => {
   return {
      type: REQUEST_SUCCESS_SPONSOR_UNITS,
      payload,
      pagination
   };
};

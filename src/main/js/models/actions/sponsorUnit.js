import { REQUEST_TEAM_UNITS, CHANGE_PAGE_PREV_TEAM_UNITS, CHANGE_PAGE_NEXT_TEAM_UNITS, REQUEST_SUCCESS_TEAM_UNITS } from 'models/actions/ActionTypes';

export const fetch = () => {
   return {
      type: REQUEST_TEAM_UNITS
   };
};

export const movePrevPage = () => {
   return {
      type: CHANGE_PAGE_PREV_TEAM_UNITS
   };
};

export const moveNextPage = () => {
   return {
      type: CHANGE_PAGE_NEXT_TEAM_UNITS
   };
};

export const requestSuccess = (payload, pagination) => {
   return {
      type: REQUEST_SUCCESS_TEAM_UNITS,
      payload,
      pagination
   };
};

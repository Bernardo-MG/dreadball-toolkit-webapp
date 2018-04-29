import { REQUEST_PLAYERS, CHANGE_PAGE_PREV_PLAYERS, CHANGE_PAGE_NEXT_PLAYERS, REQUEST_SUCCESS_PLAYERS, REQUEST_FAILURE_PLAYERS } from 'models/actions/actionTypes';

export const fetch = () => {
   return {
      type: REQUEST_PLAYERS,
      params: { orderBy: 'templateName' }
   };
};

export const movePrevPage = () => {
   return {
      type: CHANGE_PAGE_PREV_PLAYERS,
      params: { orderBy: 'templateName' }
   };
};

export const moveNextPage = () => {
   return {
      type: CHANGE_PAGE_NEXT_PLAYERS,
      params: { orderBy: 'templateName' }
   };
};

export const requestSuccess = (payload, pagination) => {
   return {
      type: REQUEST_SUCCESS_PLAYERS,
      payload,
      pagination
   };
};

export const requestFailure = (payload) => {
   return {
      type: REQUEST_FAILURE_PLAYERS,
      payload
   };
};

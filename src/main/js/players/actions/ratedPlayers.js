import { REQUEST_RATED_PLAYERS, CHANGE_PAGE_PREV_RATED_PLAYERS, CHANGE_PAGE_NEXT_RATED_PLAYERS, REQUEST_SUCCESS_RATED_PLAYERS, REQUEST_FAILURE_RATED_PLAYERS } from 'players/actions/actionTypes';

export const fetch = () => {
   return {
      type: REQUEST_RATED_PLAYERS,
      params: { sort: 'templateName' }
   };
};

export const movePrevPage = () => {
   return {
      type: CHANGE_PAGE_PREV_RATED_PLAYERS,
      params: { sort: 'templateName' }
   };
};

export const moveNextPage = () => {
   return {
      type: CHANGE_PAGE_NEXT_RATED_PLAYERS,
      params: { sort: 'templateName' }
   };
};

export const requestSuccess = (payload, pagination) => {
   return {
      type: REQUEST_SUCCESS_RATED_PLAYERS,
      payload,
      pagination
   };
};

export const requestFailure = (payload) => {
   return {
      type: REQUEST_FAILURE_RATED_PLAYERS,
      payload
   };
};

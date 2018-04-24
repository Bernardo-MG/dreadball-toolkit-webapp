import { REQUEST_TEAM_PLAYERS, CHANGE_PAGE_PREV_TEAM_PLAYERS, CHANGE_PAGE_NEXT_TEAM_PLAYERS, REQUEST_SUCCESS_TEAM_PLAYERS, REQUEST_FAILURE_TEAM_PLAYERS } from 'models/actions/actionTypes';

export const fetch = () => {
   return {
      type: REQUEST_TEAM_PLAYERS,
      params: { orderBy: 'templateName' }
   };
};

export const movePrevPage = () => {
   return {
      type: CHANGE_PAGE_PREV_TEAM_PLAYERS,
      params: { orderBy: 'templateName' }
   };
};

export const moveNextPage = () => {
   return {
      type: CHANGE_PAGE_NEXT_TEAM_PLAYERS,
      params: { orderBy: 'templateName' }
   };
};

export const requestSuccess = (payload, pagination) => {
   return {
      type: REQUEST_SUCCESS_TEAM_PLAYERS,
      payload,
      pagination
   };
};

export const requestFailure = (payload) => {
   return {
      type: REQUEST_FAILURE_TEAM_PLAYERS,
      payload
   };
};

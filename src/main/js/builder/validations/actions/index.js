import * as types from 'builder/validations/actions/actionTypes';

export const validateTeamSuccess = (payload) => {
   return {
      type: types.REQUEST_SUCCESS_TEAM_VALIDATION,
      payload
   };
};

export const validateTeamFailure = (payload) => {
   return {
      type: types.REQUEST_FAILURE_TEAM_VALIDATION,
      payload
   };
};

import * as ActionTypes from 'builder/actions/actionTypes';

export const clearTeam = () => {
   return {
      type: ActionTypes.CLEAR_TEAM
   };
};

export const setSponsorName = (value) => {
   return {
      type: ActionTypes.SET_SPONSOR_NAME,
      payload: value
   };
};

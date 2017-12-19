import * as types from 'builder/team/actions/actionTypes';

export const clearTeam = () => {
   return {
      type: types.CLEAR_TEAM
   };
};

export const setSponsorName = (value) => {
   return {
      type: types.SET_SPONSOR_NAME,
      payload: value
   };
};

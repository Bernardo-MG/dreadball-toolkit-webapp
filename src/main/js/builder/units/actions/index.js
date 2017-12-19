import * as types from 'builder/units/actions/actionTypes';

export const addTeamUnit = (unit) => {
   return {
      type: types.ADD_TEAM_UNIT,
      payload: unit
   };
};

export const removeTeamUnit = (unit) => {
   return {
      type: types.REMOVE_TEAM_UNIT,
      payload: unit
   };
};

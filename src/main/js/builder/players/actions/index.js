import * as types from 'builder/players/actions/actionTypes';

export const addTeamPlayer = (player) => {
   return {
      type: types.ADD_TEAM_PLAYER,
      payload: player
   };
};

export const removeTeamPlayer = (player) => {
   return {
      type: types.REMOVE_TEAM_PLAYER,
      payload: player
   };
};

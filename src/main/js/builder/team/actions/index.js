import * as types from 'builder/team/actions/actionTypes';

export const clearTeam = () => {
   return {
      type: types.CLEAR_TEAM
   };
};

export const validateTeam = (
   affinities = [],
   units = [],
   baseRank = 0,
   cheerleaders = 0, coachingDice = 0, mediBots = 0, specialMoveCards = 0, nastySurpriseCards = 0, wagers = 0) => {
   return {
      type: types.TEAM_VALIDATION,
      params: { affinities, units, baseRank, cheerleaders, coachingDice, mediBots, specialMoveCards, nastySurpriseCards, wagers }
   };
};

export const validateTeamSuccess = (payload) => {
   return {
      type: types.REQUEST_SUCCESS_TEAM_VALIDATION,
      payload
   };
};

export const setSponsorName = (value) => {
   return {
      type: types.SET_SPONSOR_NAME,
      payload: value
   };
};

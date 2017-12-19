import * as types from 'builder/validations/actions/actionTypes';

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

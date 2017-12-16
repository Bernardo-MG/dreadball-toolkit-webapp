import * as types from 'builder/actions/ActionTypes';

export const clearTeam = () => {
   return {
      type: types.CLEAR_TEAM
   };
};

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

export const setCoachingDice = (value) => {
   return {
      type: types.SET_COACHING_DICE,
      payload: value
   };
};

export const setSpecialMoveCard = (value) => {
   return {
      type: types.SET_SPECIAL_MOVE_CARD,
      payload: value
   };
};

export const setNastySurpriseCard = (value) => {
   return {
      type: types.SET_NASTY_SURPRISE_CARD,
      payload: value
   };
};

export const setWager = (value) => {
   return {
      type: types.SET_WAGER,
      payload: value
   };
};

export const setMediBot = (value) => {
   return {
      type: types.SET_MEDIBOT,
      payload: value
   };
};

export const setCheerleaders = (value) => {
   return {
      type: types.SET_CHEERLEADERS,
      payload: value
   };
};

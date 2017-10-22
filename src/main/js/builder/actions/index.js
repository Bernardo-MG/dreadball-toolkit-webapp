import { CALL_API } from 'api/ActionTypes';
import * as types from 'builder/actions/ActionTypes';
import { BUILDER_VALIDATION_REST_ENDPOINT as validationEndpoint, BUILDER_VALIDATION_AFFINITIES_REST_ENDPOINT as validationAffinitiesEndpoint } from 'builder/requests/Endpoints';

export const beginDbxTeamBuilding = () => {
   return {
      type: types.BEGIN_DBX_TEAM_BUILDING
   };
};

export const chooseSponsorAffinity = (affinity, index) => {
   return {
      type: types.CHOOSE_SPONSOR_AFFINITY,
      payload: affinity,
      index
   };
};

export const validateSponsorAffinities = (affinities = []) => {
   return {
      [CALL_API]: {
         tag: 'SPONSOR_TEAM_VALIDATION_AFFINITIES',
         endpoint: validationAffinitiesEndpoint,
         params: { affinities }
      }
   };
};

export const validateSponsorTeam = (
   affinities = [],
   units = [],
   baseRank = 0,
   cheerleaders = 0, coachingDice = 0, mediBots = 0, specialMoveCards = 0, nastySurpriseCards = 0, wagers = 0) => {
   return {
      [CALL_API]: {
         tag: 'SPONSOR_TEAM_VALIDATION',
         endpoint: validationEndpoint,
         params: { affinities, units, baseRank, cheerleaders, coachingDice, mediBots, specialMoveCards, nastySurpriseCards, wagers }
      }
   };
};

export const updateSponsorName = (value) => {
   return {
      type: types.UPDATE_SPONSOR_NAME,
      payload: value
   };
};

export const updateSponsorCoachingDice = (value) => {
   return {
      type: types.UPDATE_SPONSOR_COACHING_DICE,
      payload: value
   };
};

export const updateSponsorSpecialMoveCard = (value) => {
   return {
      type: types.UPDATE_SPONSOR_SPECIAL_MOVE_CARD,
      payload: value
   };
};

export const updateSponsorNastySurpriseCard = (value) => {
   return {
      type: types.UPDATE_SPONSOR_NASTY_SURPRISE_CARD,
      payload: value
   };
};

export const updateSponsorWager = (value) => {
   return {
      type: types.UPDATE_SPONSOR_WAGER,
      payload: value
   };
};

export const updateSponsorMediBot = (value) => {
   return {
      type: types.UPDATE_SPONSOR_MEDIBOT,
      payload: value
   };
};

export const updateSponsorCheerleaders = (value) => {
   return {
      type: types.UPDATE_SPONSOR_CHEERLEADERS,
      payload: value
   };
};

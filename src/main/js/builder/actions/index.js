import { CALL_API } from 'pagination/actions/ActionTypes';
import * as types from 'builder/actions/ActionTypes';
import { BUILDER_DEFAULTS_REST_ENDPOINT as defaultsEndpoint, BUILDER_AFFINITIES_VALIDATION_REST_ENDPOINT as affinitiesEndpoint } from 'builder/requests/Endpoints';

export const beginDbxTeamBuilding = () => {
   return {
      type: types.BEGIN_DBX_TEAM_BUILDING
   }
};

export const chooseSponsorAffinity = (affinity, index) => {
   return {
      type: types.CHOOSE_SPONSOR_AFFINITY,
      payload: affinity,
      index: index
   }
};

export const validateSponsorAffinities = (affinities = []) => {
   return {
      [CALL_API]: {
         types: [types.REQUEST_AFFINITIES_VALIDATION, types.REQUEST_AFFINITIES_VALIDATION_SUCCESS, types.REQUEST_AFFINITIES_VALIDATION_FAILURE],
         endpoint: affinitiesEndpoint,
         params: { affinities }
      }
   }
};

export const chooseSponsorUnit = (unit) => {
   return {
      type: types.CHOOSE_SPONSOR_UNIT,
      payload: unit
   }
};

export const reloadSponsorTeamValue = () => {
   return {
      type: types.RELOAD_SPONSOR_TEAM_VALUE
   }
};

export const updateSponsorCoachingDice = (value) => {
   return {
      type: types.UPDATE_SPONSOR_COACHING_DICE,
      payload: value
   }
};

export const updateSponsorSpecialMoveCard = (value) => {
   return {
      type: types.UPDATE_SPONSOR_SPECIAL_MOVE_CARD,
      payload: value
   }
};

export const updateSponsorNastySurpriseCard = (value) => {
   return {
      type: types.UPDATE_SPONSOR_NASTY_SURPRISE_CARD,
      payload: value
   }
};

export const updateSponsorWager = (value) => {
   return {
      type: types.UPDATE_SPONSOR_WAGER,
      payload: value
   }
};

export const updateSponsorMediBot = (value) => {
   return {
      type: types.UPDATE_SPONSOR_MEDIBOT,
      payload: value
   }
};

export const updateSponsorCheerleaders = (value) => {
   return {
      type: types.UPDATE_SPONSOR_CHEERLEADERS,
      payload: value
   }
};

export const loadDefaults = () => {
   return {
      [CALL_API]: {
         types: [types.REQUEST_BUILDER_DEFAULTS, types.REQUEST_BUILDER_DEFAULTS_SUCCESS, types.REQUEST_BUILDER_DEFAULTS_FAILURE],
         endpoint: defaultsEndpoint
      }
   }
};

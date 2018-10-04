import * as types from 'builder/affinities/actions/actionTypes';

export const chooseSponsorAffinity = (affinity, index) => {
   return {
      type: types.CHOOSE_SPONSOR_AFFINITY,
      payload: affinity,
      index
   };
};

export const validateSponsorAffinities = (affinities = []) => {
   return {
      type: types.TEAM_AFFINITIES_VALIDATION,
      params: { affinities }
   };
};

export const validationSuccess = (payload) => {
   return {
      type: types.REQUEST_SUCCESS_TEAM_VALIDATION_AFFINITIES,
      payload
   };
};

export const validationFailure = (payload) => {
   return {
      type: types.REQUEST_FAILURE_TEAM_VALIDATION_AFFINITIES,
      payload
   };
};

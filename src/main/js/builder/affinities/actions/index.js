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

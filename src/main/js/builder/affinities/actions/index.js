import * as types from 'builder/affinities/actions/actionTypes';

export const fetchAffinityOptions = () => {
   return {
      type: types.REQUEST_SPONSOR_AFFINITY_GROUP_OPTIONS
   };
};

export const optionsRequestSuccess = (payload) => {
   return {
      type: types.REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_OPTIONS,
      payload
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

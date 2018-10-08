import * as types from 'builder/requests/affinities/actions/actionTypes';

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

export const optionsRequestFailure = (payload) => {
   return {
      type: types.REQUEST_FAILURE_SPONSOR_AFFINITY_GROUP_OPTIONS,
      payload
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

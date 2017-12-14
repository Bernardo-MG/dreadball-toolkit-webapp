import { REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_AVAILABILITIES } from 'models/actions/ActionTypes';

export const fetch = () => {
   return {
      type: REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES
   };
};

export const requestSuccess = (payload) => {
   return {
      type: REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_AVAILABILITIES,
      payload
   };
};

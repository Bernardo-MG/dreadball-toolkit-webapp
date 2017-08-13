import { REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE } from 'requests/actions/ActionTypes';
import { CALL_API_STATUS } from 'fetch/actions/ActionTypes';
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT as endpoint } from 'requests/Endpoints';
import { jsonToSponsorAffinityGroupAvailabilities as parse } from 'requests/utils/sponsorAffAva';

export const fetch = () => {
   return {
      [CALL_API_STATUS]: {
         types: [REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE],
         endpoint,
         parse
      }
   };
};

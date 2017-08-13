import { REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE } from 'requests/actions/ActionTypes';
import { CALL_API_PAGINATED } from 'pagination/actions/ActionTypes';
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT as endpoint } from 'requests/Endpoints';
import { jsonToSponsorAffinityGroupAvailabilities as parse } from 'requests/utils/sponsorAffAva';

export const fetch = (page = 0) => {
   return {
      [CALL_API_PAGINATED]: {
         types: [REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE],
         endpoint,
         page,
         parse
      }
   };
};

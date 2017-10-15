import { REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE, CREATE_AFFINITIES, CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES } from 'models/actions/ActionTypes';
import { CALL_API } from 'api/ActionTypes';
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { sponsorAffinityAvailability } from 'models/schema';
import { fetchPaginated } from 'api/fetch';

export const parse = (json) => normalize(json, [sponsorAffinityAvailability]);

export const fetch = () => {
   return {
      [CALL_API]: {
         requestType: REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES,
         successType: REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS,
         failureType: REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE,
         chained: [CREATE_AFFINITIES, CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES],
         endpoint,
         fetch: (url, params) => fetchPaginated(url, params, parse)
      }
   };
};

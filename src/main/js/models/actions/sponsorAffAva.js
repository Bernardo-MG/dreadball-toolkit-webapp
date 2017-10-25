import { CREATE_AFFINITIES, CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES } from 'models/actions/ActionTypes';
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { sponsorAffinityAvailability } from 'models/schema';
import { fetchPaginated } from 'api/fetch';
import { callApi } from 'api/actions';

export const parse = (json) => normalize(json, [sponsorAffinityAvailability]);

const tag = 'SPONSOR_AFFINITY_GROUP_AVAILABILITIES';

export const fetch = () => callApi({
   tag,
   chained: [CREATE_AFFINITIES, CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES],
   endpoint,
   fetch: (url, params) => fetchPaginated(url, params, parse)
});

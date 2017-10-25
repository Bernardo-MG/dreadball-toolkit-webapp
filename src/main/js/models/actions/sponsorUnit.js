import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_RATED_UNITS } from 'models/actions/ActionTypes';
import { SPONSOR_AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { unit } from 'models/schema';
import { fetchPaginated } from 'api/fetch';
import { callApi, previousPage, nextPage } from 'api/actions';

const parse = (json) => normalize(json, [unit]);

const tag = 'SPONSOR_UNITS';

export const fetch = (affinities = {}, page = 0, orderBy = 'name', direction = 'ASC') => callApi({
   tag,
   chained: [CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_RATED_UNITS],
   endpoint,
   page,
   fetch: (url, params) => fetchPaginated(url, params, parse),
   orderBy,
   direction,
   params: { affinities }
});

export const movePrevPage = () => previousPage({
   tag,
   storeSelector: (state) => state.pagination.ratedUnits,
   fetch
});

export const moveNextPage = () => nextPage({
   tag,
   storeSelector: (state) => state.pagination.ratedUnits,
   fetch
});

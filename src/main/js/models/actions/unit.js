import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS } from 'models/actions/ActionTypes';
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { unit } from 'models/schema';
import { fetchPaginated } from 'api/fetch';
import { callApi, previousPage, nextPage } from 'api/actions';

const parse = (json) => normalize(json, [unit]);

const tag = 'UNITS';

export const fetch = (page = 0, orderBy = 'name', direction = 'ASC', replace = false) => callApi({
   tag,
   chained: [CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS],
   endpoint,
   page,
   fetch: (url, params) => fetchPaginated(url, params, parse),
   orderBy,
   direction,
   replace
});

export const movePrevPage = () => previousPage({
   tag,
   storeSelector: (state) => state.pagination.units,
   fetch
});

export const moveNextPage = () => nextPage({
   tag,
   storeSelector: (state) => state.pagination.units,
   fetch
});

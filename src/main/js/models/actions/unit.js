import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS } from 'models/actions/ActionTypes';
import { CALL_API, CHANGE_PAGE } from 'api/ActionTypes';
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { unit } from 'models/schema';
import { fetchPaginated } from 'api/fetch';

const parse = (json) => normalize(json, [unit]);

const tag = 'UNITS';

export const fetch = (page = 0, orderBy = 'name', direction = 'ASC', replace = false) => {
   return {
      [CALL_API]: {
         tag,
         chained: [CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS],
         endpoint,
         page,
         fetch: (url, params) => fetchPaginated(url, params, parse),
         orderBy,
         direction,
         replace
      }
   };
};

export const movePrevPage = () => {
   return {
      type: CHANGE_PAGE,
      direction: 'PREV',
      tag,
      storeSelector: (state) => state.pagination.units,
      fetch
   };
};

export const moveNextPage = () => {
   return {
      type: CHANGE_PAGE,
      direction: 'NEXT',
      tag,
      storeSelector: (state) => state.pagination.units,
      fetch
   };
};

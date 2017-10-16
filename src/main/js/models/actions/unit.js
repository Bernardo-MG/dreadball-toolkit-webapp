import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_RATED_UNITS } from 'models/actions/ActionTypes';
import { CALL_API } from 'api/ActionTypes';
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { unit } from 'models/schema';
import { fetchPaginated } from 'api/fetch';

const parse = (json) => normalize(json, [unit]);

export const fetch = (page = 0, orderBy = 'name', direction = 'ASC', replace = false) => {
   return {
      [CALL_API]: {
         store: 'UNITS',
         chained: [CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_RATED_UNITS],
         endpoint,
         page,
         fetch: (url, params) => fetchPaginated(url, params, parse),
         orderBy,
         direction,
         replace
      }
   };
};

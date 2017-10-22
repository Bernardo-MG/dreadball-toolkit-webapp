import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS } from 'models/actions/ActionTypes';
import { CALL_API } from 'api/ActionTypes';
import { SPONSOR_AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { unit } from 'models/schema';
import { fetchPaginated } from 'api/fetch';

const parse = (json) => normalize(json, [unit]);

export const fetch = (affinities = {}, page = 0, orderBy = 'name', direction = 'ASC') => {
   return {
      [CALL_API]: {
         tag: 'SPONSOR_UNITS',
         chained: [CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS],
         endpoint,
         page,
         fetch: (url, params) => fetchPaginated(url, params, parse),
         orderBy,
         direction,
         params: { affinities }
      }
   };
};

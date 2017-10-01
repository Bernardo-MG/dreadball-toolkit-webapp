import { REQUEST_SPONSOR_UNITS, REQUEST_SPONSOR_UNITS_SUCCESS, REQUEST_SPONSOR_UNITS_FAILURE } from 'models/actions/ActionTypes';
import { CALL_API } from 'api/ActionTypes';
import { SPONSOR_AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { unit } from 'models/schema';

const parse = (json) => normalize(json, [unit]);

export const fetch = (affinities = {}, page = 0, orderBy = 'name', direction = 'ASC') => {
   return {
      [CALL_API]: {
         types: [REQUEST_SPONSOR_UNITS, REQUEST_SPONSOR_UNITS_SUCCESS, REQUEST_SPONSOR_UNITS_FAILURE],
         endpoint,
         page,
         parse,
         orderBy,
         direction,
         params: { affinities }
      }
   };
};

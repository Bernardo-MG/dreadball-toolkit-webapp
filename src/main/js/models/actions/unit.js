import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE } from 'models/actions/ActionTypes';
import { CALL_API } from 'api/ActionTypes';
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { normalize } from 'normalizr';
import { unit } from 'models/schema';

const parse = (json) => normalize(json, [unit]);

export const fetch = (page = 0, orderBy = 'name', direction = 'ASC', replace = false) => {
   return {
      [CALL_API]: {
         types: [REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE],
         endpoint,
         page,
         parse,
         orderBy,
         direction,
         replace
      }
   };
};

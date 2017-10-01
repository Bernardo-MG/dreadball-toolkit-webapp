import { REQUEST_SPONSOR_UNITS, REQUEST_SPONSOR_UNITS_SUCCESS, REQUEST_SPONSOR_UNITS_FAILURE } from 'requests/actions/ActionTypes';
import { CALL_API_PAGINATED } from 'api/pagination/actions/ActionTypes';
import { SPONSOR_AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'requests/Endpoints';
import { jsonToUnits as parse } from 'requests/utils/unit';

export const fetch = (affinities = {}, page = 0, orderBy = 'name', direction = 'ASC') => {
   return {
      [CALL_API_PAGINATED]: {
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

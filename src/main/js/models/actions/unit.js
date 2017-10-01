import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE } from 'models/actions/ActionTypes';
import { CALL_API_PAGINATED } from 'api/pagination/actions/ActionTypes';
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'requests/Endpoints';
import { jsonToUnits as parse } from 'requests/utils/unit';

export const fetch = (page = 0, orderBy = 'name', direction = 'ASC', replace = false) => {
   return {
      [CALL_API_PAGINATED]: {
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

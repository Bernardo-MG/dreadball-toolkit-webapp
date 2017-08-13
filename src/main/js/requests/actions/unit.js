import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE, REQUEST_UNITS_CLEAR } from 'requests/actions/ActionTypes';
import { CALL_API_PAGINATED } from 'pagination/actions/ActionTypes';
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'requests/Endpoints';
import { jsonToUnits as parse } from 'requests/utils/unit';

export const fetch = (page = 0, orderBy = 'name', order = 'ASC') => {
   return {
      [CALL_API_PAGINATED]: {
         types: [REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE],
         endpoint,
         page,
         parse,
         orderBy,
         order
      }
   };
};

export const clear = () => {
   return {
      type: REQUEST_UNITS_CLEAR
   };
};

import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE } from 'requests/actions/ActionTypes'
import { CALL_API } from 'pagination/actions/ActionTypes'
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'requests/Endpoints'
import { transformAffinityUnitsJson as parse } from 'requests/utils/unit'

export const fetch = (page=0, orderBy='name', order='ASC') => ({
  [CALL_API]: {
    types: [ REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE ],
    endpoint,
    page,
    parse,
    orderBy,
    order
  }
})

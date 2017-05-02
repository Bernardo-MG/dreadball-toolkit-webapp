import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE, CALL_API } from 'actions/ActionTypes'
import { AFFINITY_UNITS_REST_ENDPOINT as URL } from 'constants/RestUrls'
import { transformAffinityUnitsJson as parse } from 'utils/codex'

export const fetch = (page=0, orderBy='name', order='ASC') => ({
  [CALL_API]: {
    types: [ REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE ],
    endpoint: URL,
    page,
    parse,
    orderBy,
    order
  }
})

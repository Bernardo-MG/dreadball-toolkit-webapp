import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE, CALL_API } from 'actions/ActionTypes'
import { AFFINITY_UNITS_REST_ENDPOINT as URL } from 'constants/RestUrls'
import { transformAffinityUnitsJson as parse } from 'utils/codex'

export const fetch = (page=0) => ({
  [CALL_API]: {
    types: [ REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE ],
    endpoint: URL,
    page: page,
    parse: parse
  }
})

const parseAffinitiesUrl = (url, affinities) => {
   var result;
   
   result = url;
   if((affinities) && (affinities.length)) {
      result += "?affinities=" + affinities.join();
   }
   
   return result;
}

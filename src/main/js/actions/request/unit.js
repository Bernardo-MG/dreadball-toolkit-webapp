import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE } from 'constants/ActionTypes'
import { AFFINITY_UNITS_REST_ENDPOINT as URL } from 'constants/RestUrls'
import { transformAffinityUnitsJson as parse } from 'utils/codex'
import { CALL_API } from 'middleware/api'

export const fetch = (affinities) => ({
  [CALL_API]: {
    types: [ REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE ],
    endpoint: URL,
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

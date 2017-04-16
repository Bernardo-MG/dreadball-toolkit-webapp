import { REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE } from 'constants/ActionTypes'
import { AFFINITY_UNITS_REST_ENDPOINT as URL } from 'constants/RestUrls'
import { transformAffinityUnitsJson as parse } from 'utils/codex'
import { fetchData } from 'utils/request'
import { CALL_API } from 'middleware/api'

export const request = () => ({
   type: REQUEST_UNITS
})

export const requestSuccess = (data) => ({
   type: REQUEST_UNITS_SUCCESS,
   payload: data
})

const fetchUnits = () => ({
  [CALL_API]: {
    types: [ REQUEST_UNITS, REQUEST_UNITS_SUCCESS, REQUEST_UNITS_FAILURE ],
    endpoint: URL,
    parse: parse
  }
})

export const fetch = (affinities) => dispatch => {
   dispatch(fetchUnits())
}

const parseAffinitiesUrl = (url, affinities) => {
   var result;
   
   result = url;
   if((affinities) && (affinities.length)) {
      result += "?affinities=" + affinities.join();
   }
   
   return result;
}

const handleReceive = (json, dispatch) => {
   const units = parse(json);
   
   dispatch(requestSuccess(units))
}

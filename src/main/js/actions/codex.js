import * as types from '../constants/ActionTypes'
import { AFFINITY_UNITS_REST_ENDPOINT } from '../constants/RestUrls'
import { transformAffinityUnitsJson } from '../utils/codex'
import { fetchData } from '../utils/request'

export const requestUnits = () => ({
   type: types.REQUEST_UNITS
})

export const receiveUnits = (json, intl) => ({
   type: types.RECEIVE_UNITS,
   units: transformAffinityUnitsJson(json, intl)
})

export const fetchUnits = (intl, affinities) => dispatch => {
   var url;
   
   dispatch(requestUnits())
   
   url = AFFINITY_UNITS_REST_ENDPOINT;
   
   if((affinities) && (affinities.length)){
      url += "?affinities=" + affinities.join();
   }
   
   return fetchData(url, (json) => dispatch(receiveUnits(json, intl)))
}
import * as types from 'constants/ActionTypes'
import { AFFINITY_UNITS_REST_ENDPOINT as URL } from 'constants/RestUrls'
import { transformAffinityUnitsJson as parse } from 'utils/codex'
import { fetchData } from 'utils/request'

export const request = () => ({
   type: types.REQUEST_UNITS
})

export const requestSuccess = (data) => ({
   type: types.REQUEST_UNITS_SUCCESS,
   payload: data
})

export const fetch = (intl, affinities) => dispatch => {
   dispatch(request())
   
   const url = parseAffinitiesUrl(URL, affinities);
   
   return fetchData(url, (json) => handleReceive(json, intl, dispatch));
}

const parseAffinitiesUrl = (url, affinities) => {
   var result;
   
   result = url;
   if((affinities) && (affinities.length)){
      result += "?affinities=" + affinities.join();
   }
   
   return result;
}

const handleReceive = (json, intl, dispatch) => {
   const units = parse(json, intl);
   const ids = units.map(unit => unit.templateName);
   
   dispatch(requestSuccess({ ids, entities: units }))
}

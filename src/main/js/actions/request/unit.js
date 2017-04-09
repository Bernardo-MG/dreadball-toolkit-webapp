import * as types from '../../constants/ActionTypes'
import { AFFINITY_UNITS_REST_ENDPOINT as URL } from '../../constants/RestUrls'
import { transformAffinityUnitsJson as transform } from '../../utils/codex'
import { fetchData } from '../../utils/request'

export const create = (unit) => ({
   type: types.CREATE_PLAYER,
   payload: unit
})

export const request = () => ({
   type: types.REQUEST_UNITS
})

export const receive = (json, intl) => dispatch => {
   var players = transform(json, intl);
   for (var i=0; i<players.length; i++) {
      dispatch(create(players[i]))
   }
   
   return {
   type: types.RECEIVE_UNITS,
   payload: players
}}

export const fetch = (intl, affinities) => dispatch => {
   var url;
   
   dispatch(request())
   
   url = parseAffinitiesUrl(URL, affinities);
   
   if((affinities) && (affinities.length)){
      url += "?affinities=" + affinities.join();
   }
   
   return fetchData(url, (json) => dispatch(receive(json, intl)));
}

const parseAffinitiesUrl = (url, affinities) => {
   var result;
   
   result = url;
   if((affinities) && (affinities.length)){
      result += "?affinities=" + affinities.join();
   }
   
   return result;
}
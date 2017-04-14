import * as types from 'constants/ActionTypes'
import { AFFINITY_UNITS_REST_ENDPOINT as URL } from 'constants/RestUrls'
import { transformAffinityUnitsJson as transform } from 'utils/codex'
import { fetchData } from 'utils/request'

export const create = (unit) => ({
   type: types.CREATE_PLAYERS,
   payload: unit
})

export const request = () => ({
   type: types.REQUEST_UNITS
})

export const receive = (players) => dispatch => ({
   type: types.RECEIVE_UNITS,
   payload: players
})

export const fetch = (intl, affinities) => dispatch => {
   var url;
   
   dispatch(request())
   
   url = parseAffinitiesUrl(URL, affinities);
   
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
   var players = transform(json, intl);
   dispatch(create(players))
   
   dispatch(receive(players))
}

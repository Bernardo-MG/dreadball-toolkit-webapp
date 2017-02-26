import * as types from '../constants/ActionTypes'
import { CODEX_AFFINITY_UNITS } from '../constants/RestUrls'
import fetch from 'isomorphic-fetch'
import { transformAffinityUnitsJson } from '../utils/codex'

export const requestUnits = () => ({
   type: types.REQUEST_UNITS
})

export const receiveUnits = (json, intl) => ({
   type: types.RECEIVE_UNITS,
   units: transformAffinityUnitsJson(json, intl)
})

export const fetchUnits = (intl) => dispatch => {
   dispatch(requestUnits())
   
   return fetch(CODEX_AFFINITY_UNITS)
      .then(response => response.json())
      .then(json => dispatch(receiveUnits(json, intl)))
}
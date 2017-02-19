import * as types from '../constants/ActionTypes'
import fetch from 'isomorphic-fetch'

export const loadUnits = (units) => ({
  type: types.LOAD_UNITS,
  units
})

export const requestUnits = () => ({
  type: types.REQUEST_UNITS
})

export const receiveUnits = (json) => ({
  type: types.RECEIVE_UNITS,
  units: json
})

export const fetchUnits = () => dispatch => {
    dispatch(requestUnits())
    
    return fetch('./rest/codex/unit')
      .then(response => response.json())
      .then(json =>
        dispatch(receiveUnits(json))
      )
}
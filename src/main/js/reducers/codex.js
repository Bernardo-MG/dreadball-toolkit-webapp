import * as types from '../constants/ActionTypes'
import { combineReducers } from 'redux'

const units = (state = [], action) => {
  switch (action.type) {
    case types.LOAD_UNITS:
      return action.units
    default:
      return state
  }
}

const unitsAsync = (state = {
  isFetching: false,
  units: []
}, action) => {
  switch (action.type) {
    case types.REQUEST_UNITS:
      return Object.assign({}, state, {
        isFetching: true
      })
    case types.RECEIVE_UNITS:
      return Object.assign({}, state, {
        isFetching: false,
        units: action.units
      })
    default:
      return state
  }
}

const rootReducer = combineReducers({
  units,
  unitsAsync
})

export default rootReducer
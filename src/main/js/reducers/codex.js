import * as types from '../constants/ActionTypes'

const units = (state = [], action) => {
  switch (action.type) {
    case types.LOAD_UNITS:
      return action.units
    default:
      return state
  }
}

export default units
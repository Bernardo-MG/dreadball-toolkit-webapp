import * as types from '../constants/ActionTypes'

const players = (state = [], action) => {
  switch (action.type) {
    case types.LOAD_PLAYERS:
      return action.units
    default:
      return state
  }
}

export default players
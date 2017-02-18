import * as types from '../constants/ActionTypes'

export const loadPlayers = (units) => ({
  type: types.LOAD_PLAYERS,
  units
})

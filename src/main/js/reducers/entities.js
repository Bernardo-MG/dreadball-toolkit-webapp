import * as types from 'constants/ActionTypes'

const unitsAsync = (state = { isFetching: false, players: [] }, action) => {
   const { type, payload } = action;
   switch (type) {
      case types.REQUEST_UNITS:
         return Object.assign({}, state, {})
      case types.RECEIVE_UNITS:
         return Object.assign({}, state, { players: payload })
      default:
         return state
   }
}

export default unitsAsync
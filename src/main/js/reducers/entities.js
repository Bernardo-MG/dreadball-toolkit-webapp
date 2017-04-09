import * as types from '../constants/ActionTypes'

const unitsAsync = (state = { isFetching: false, units: [] }, action) => {
   switch (action.type) {
      case types.REQUEST_UNITS:
         return Object.assign({}, state, {})
      case types.RECEIVE_UNITS:
         return Object.assign({}, state, { units: action.entities })
      default:
         return state
   }
}

export default unitsAsync
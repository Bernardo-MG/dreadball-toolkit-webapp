import * as types from 'constants/ActionTypes'

const unitsAsync = (state = { isFetching: false, units: [] }, action) => {
   const { type, payload } = action;
   switch (type) {
      case types.REQUEST_UNITS:
         return Object.assign({}, state, {})
      case types.RECEIVE_UNITS:
         return Object.assign({}, state, { units: payload })
      default:
         return state
   }
}

export default unitsAsync
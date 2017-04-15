import * as ActionTypes from 'constants/ActionTypes'

const unitsAsync = (state = { isFetching: false, units: [] }, action) => {
   const { type, payload } = action;
   switch (type) {
      case ActionTypes.REQUEST_UNITS:
         return Object.assign({}, state, {})
      case ActionTypes.RECEIVE_UNITS:
         return Object.assign({}, state, { units: payload })
      default:
         return state
   }
}

export default unitsAsync
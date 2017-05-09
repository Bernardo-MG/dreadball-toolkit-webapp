import * as ActionTypes from 'builder/actions/ActionTypes'
import { combineReducers } from 'redux'

const sponsor = (state = { rank : 0, affinities : [] }, action) => {
   const { type } = action;
   switch (type) {
      case ActionTypes.BEGIN_DBX_TEAM_BUILDING:
         return {
            rank : 0,
            affinities : []
         }
      case ActionTypes.CHOOSE_SPONSOR_AFFINITY:
         var affinities = state.affinities.slice();
         affinities[action.index] = action.affinity;
         return {
            ...state,
            affinities
         }
      default:
         return state
   }
}

const dbxBuilderReducer = combineReducers({
  sponsor
})

export default dbxBuilderReducer
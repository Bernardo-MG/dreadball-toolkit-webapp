import * as ActionTypes from 'builder/actions/ActionTypes'
import { combineReducers } from 'redux'

const sponsorChosenAffinities = (state = [], action) => {
   const { type } = action;
   switch (type) {
      case ActionTypes.BEGIN_DBX_TEAM_BUILDING:
         return []
      case ActionTypes.CHOOSE_SPONSOR_AFFINITY:
         var affinities = state.slice();
         
         affinities[action.index] = action.affinity;
         
         return affinities
      default:
         return state
   }
}

const sponsor = (state = { rank : 0 }, action) => {
   const { type } = action;
   switch (type) {
      case ActionTypes.BEGIN_DBX_TEAM_BUILDING:
         return {
            rank : 0
         }
      default:
         return state
   }
}

const dbxBuilderReducer = combineReducers({
  sponsorChosenAffinities,
  sponsor
})

export default dbxBuilderReducer
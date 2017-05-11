import * as ActionTypes from 'builder/actions/ActionTypes'
import { combineReducers } from 'redux'

const sponsor = (state = { rank : 0, affinities : [], ranks : [] }, action) => {
   const { type } = action;
   switch (type) {
      case ActionTypes.BEGIN_DBX_TEAM_BUILDING:
         return {
            affinities : [],
            ranks : []
         }
      case ActionTypes.CHOOSE_SPONSOR_AFFINITY:
         const affinities = state.affinities.slice();
         const ranks = state.ranks.slice();

         affinities[action.index] = action.payload.affinity;
         ranks[action.index] = action.payload.rank;
         
         return {
            ...state,
            affinities,
            ranks
         }
      default:
         return state
   }
}

const dbxBuilderReducer = combineReducers({
  sponsor
})

export default dbxBuilderReducer
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
         const affinities = state.affinities.slice();
         var rank = state.rank;
         
         if(action.payload.rank){
            affinities[action.index] = null;
            rank = rank+1;
         } else {
            affinities[action.index] = action.payload.affinity;
         }
         
         return {
            ...state,
            rank,
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
import * as ActionTypes from 'actions/ActionTypes'
import { combineReducers } from 'redux'

const sponsorAffinityGroupAvailabilities = (state = { isFetching: false, availabilities: [] }, action) => {
   const { type } = action;
   switch (type) {
      case ActionTypes.BEGIN_DBX_TEAM_BUILDING:
         return Object.assign({}, state, { availabilities: [] })
      case ActionTypes.REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES:
         return Object.assign({}, state, {})
      case ActionTypes.RECEIVE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES:
         return Object.assign({}, state, { availabilities: action.sponsorAffinityGroupAvailabilities })
      default:
         return state
   }
}

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
  sponsorAffinityGroupAvailabilities,
  sponsorChosenAffinities,
  sponsor
})

export default dbxBuilderReducer
import * as types from '../constants/ActionTypes'
import { combineReducers } from 'redux'

const sponsorAffinityGroupAvailabilities = (state = { isFetching: false, availabilities: [] }, action) => {
   switch (action.type) {
      case types.BEGIN_DBX_TEAM_BUILDING:
         return Object.assign({}, state, { isFetching: false, availabilities: [] })
      case types.REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES:
         return Object.assign({}, state, { isFetching: true })
      case types.RECEIVE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES:
         return Object.assign({}, state, { isFetching: false, availabilities: action.sponsorAffinityGroupAvailabilities })
      default:
         return state
   }
}

const sponsorChosenAffinities = (state = [], action) => {
   switch (action.type) {
      case types.BEGIN_DBX_TEAM_BUILDING:
         return []
      case types.CHOOSE_SPONSOR_AFFINITY:
         var affinities = state.slice();
         
         affinities[action.index] = action.affinity;
         
         return affinities
      default:
         return state
   }
}

const sponsor = (state = { rank : 0 }, action) => {
   switch (action.type) {
      case types.BEGIN_DBX_TEAM_BUILDING:
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
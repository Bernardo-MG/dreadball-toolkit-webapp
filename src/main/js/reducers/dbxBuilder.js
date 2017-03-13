import * as types from '../constants/ActionTypes'
import { combineReducers } from 'redux'

const sponsorAffinityGroupAvailabilitiesAsync = (state = { isFetching: false, sponsorAffinityGroupAvailabilities: [] }, action) => {
   switch (action.type) {
      case types.REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES:
         return Object.assign({}, state, { isFetching: true })
      case types.RECEIVE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES:
         return Object.assign({}, state, { isFetching: false, sponsorAffinityGroupAvailabilities: action.sponsorAffinityGroupAvailabilities })
      default:
         return state
   }
}

export default sponsorAffinityGroupAvailabilitiesAsync
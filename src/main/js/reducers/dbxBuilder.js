import * as types from '../constants/ActionTypes'
import { combineReducers } from 'redux'

const affinityGroupsAsync = (state = { isFetching: false, affinityGroups: [] }, action) => {
   switch (action.type) {
      case types.REQUEST_AFFINITY_GROUPS:
         return Object.assign({}, state, { isFetching: true })
      case types.RECEIVE_AFFINITY_GROUPS:
         return Object.assign({}, state, { isFetching: false, affinityGroups: action.affinityGroups })
      default:
         return state
   }
}

export default affinityGroupsAsync
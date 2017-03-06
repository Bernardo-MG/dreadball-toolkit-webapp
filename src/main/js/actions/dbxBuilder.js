import * as types from '../constants/ActionTypes'

export const requestAffinityGroups = () => ({
   type: types.REQUEST_AFFINITY_GROUPS
})

export const receiveAffinityGroups = (json, intl) => ({
   type: types.RECEIVE_AFFINITY_GROUPS,
   affinityGroups: []
})

export const fetchAffinityGroups = (intl) => dispatch => {
   dispatch(requestAffinityGroups())
   
   return []
}
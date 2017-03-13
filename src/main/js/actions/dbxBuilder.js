import * as types from '../constants/ActionTypes'
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT } from '../constants/RestUrls'
import fetch from 'isomorphic-fetch'
import { transformAffinityGroupsJson } from '../utils/dbxBuilder'

export const requestAffinityGroups = () => ({
   type: types.REQUEST_AFFINITY_GROUPS
})

export const receiveAffinityGroups = (json, intl) => ({
   type: types.RECEIVE_AFFINITY_GROUPS,
   affinityGroups: transformAffinityGroupsJson(json, intl)
})

export const fetchAffinityGroups = (intl) => dispatch => {
   dispatch(requestAffinityGroups())
   
   return fetch(SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT)
      .then(response => response.json())
      .then(json => dispatch(receiveAffinityGroups(json, intl)))
}
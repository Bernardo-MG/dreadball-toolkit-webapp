import * as types from '../constants/ActionTypes'
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT } from '../constants/RestUrls'
import fetch from 'isomorphic-fetch'
import { transformSponsorAffinityGroupAvailabilitiesJson } from '../utils/dbxBuilder'

export const requestSponsorAffinityGroupAvailabilities = () => ({
   type: types.REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES
})

export const receiveSponsorAffinityGroupAvailabilities = (json, intl) => ({
   type: types.RECEIVE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES,
   sponsorAffinityGroupAvailabilities: transformSponsorAffinityGroupAvailabilitiesJson(json, intl)
})

export const fetchSponsorAffinityGroupAvailabilities = (intl) => dispatch => {
   dispatch(requestSponsorAffinityGroupAvailabilities())
   
   return fetch(SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT)
      .then(response => response.json())
      .then(json => dispatch(receiveSponsorAffinityGroupAvailabilities(json, intl)))
}

export const chooseSponsorAffinity = (affinity, index) => ({
   type: types.CHOOSE_SPONSOR_AFFINITY,
   affinity: affinity,
   index: index
})

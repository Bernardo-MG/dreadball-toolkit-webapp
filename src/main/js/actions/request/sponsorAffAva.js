import * as types from '../../constants/ActionTypes'
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT } from '../../constants/RestUrls'
import { transformSponsorAffinityGroupAvailabilitiesJson } from '../../utils/dbxBuilder'
import { fetchData } from '../../utils/request'

export const requestSponsorAffinityGroupAvailabilities = () => ({
   type: types.REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES
})

export const receiveSponsorAffinityGroupAvailabilities = (json, intl) => ({
   type: types.RECEIVE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES,
   sponsorAffinityGroupAvailabilities: transformSponsorAffinityGroupAvailabilitiesJson(json, intl)
})

export const fetchSponsorAffinityGroupAvailabilities = (intl) => dispatch => {
   var url;
   
   dispatch(requestSponsorAffinityGroupAvailabilities())
   
   url = SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT;
   
   return fetchData(url, (json) => dispatch(receiveSponsorAffinityGroupAvailabilities(json, intl)))
}

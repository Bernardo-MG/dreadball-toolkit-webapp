import * as types from 'constants/ActionTypes'
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT as URL } from 'constants/RestUrls'
import { transformSponsorAffinityGroupAvailabilitiesJson as transform } from 'utils/dbxBuilder'
import { fetchData } from 'utils/request'

export const request = () => ({
   type: types.REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES
})

export const receive = (json, intl) => ({
   type: types.RECEIVE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES,
   sponsorAffinityGroupAvailabilities: transform(json, intl)
})

export const fetch = (intl) => dispatch => {
   dispatch(request())
   
   return fetchData(URL, (json) => dispatch(receive(json, intl)))
}

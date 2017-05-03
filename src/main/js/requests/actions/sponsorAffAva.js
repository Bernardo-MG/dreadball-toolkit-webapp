import { REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE } from 'requests/actions/ActionTypes'
import { CALL_API } from 'pagination/actions/ActionTypes'
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT as endpoint } from 'requests/Endpoints'
import { transformSponsorAffinityGroupAvailabilitiesJson as parse } from 'requests/utils/sponsorAffAva'

export const fetch = () => ({
  [CALL_API]: {
    types: [ REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_FAILURE ],
    endpoint,
    parse
  }
})

import { CALL_API } from 'pagination/actions/ActionTypes';
import * as types from 'builder/actions/ActionTypes';
import { BUILDER_DEFAULTS_REST_ENDPOINT as endpoint } from 'builder/requests/Endpoints';
import { jsonToBuilderDefaults as parse } from 'builder/requests/utils';

export const beginDbxTeamBuilding = () => ({
   type: types.BEGIN_DBX_TEAM_BUILDING
});

export const chooseSponsorAffinity = (affinity, rank, index) => ({
   type: types.CHOOSE_SPONSOR_AFFINITY,
   payload: { affinity, rank },
   index: index
});

export const updateSponsorAffinityRank = () => ({
   type: types.UPDATE_SPONSOR_AFFINITY_RANK
});

export const loadDefaults = () => ({
   [CALL_API]: {
      types: [types.REQUEST_BUILDER_DEFAULTS, types.REQUEST_BUILDER_DEFAULTS_SUCCESS, types.REQUEST_BUILDER_DEFAULTS_FAILURE],
      endpoint
   }
});
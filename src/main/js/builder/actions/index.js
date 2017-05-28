import * as types from 'builder/actions/ActionTypes';

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

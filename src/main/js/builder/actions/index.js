import * as types from 'builder/actions/ActionTypes'

export const beginDbxTeamBuilding = () => ({
   type: types.BEGIN_DBX_TEAM_BUILDING
})

export const chooseSponsorAffinity = (affinity, index) => ({
   type: types.CHOOSE_SPONSOR_AFFINITY,
   affinity: affinity,
   index: index
})

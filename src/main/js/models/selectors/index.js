import { createSelector } from 'reselect';
import { filterByKeys, selectAllValues } from 'models/selectors/utils';

export const selectPlayers = (state) => selectAllValues(state.model.players);

export const selectRatedPlayers = createSelector(
   (state) => state.model.ratedPlayers,
   (state) => state.pagination.ratedPlayers.ids,
   (data, ids) => filterByKeys(data, ids)
);

export const selectSponsorAffinities = (state) => state.builder.affinities.chosen;

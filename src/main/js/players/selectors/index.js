import { createSelector } from 'reselect';
import { filterByKeys } from 'players/selectors/utils';

export const selectPlayers = createSelector(
   (state) => state.model.players,
   (state) => state.pagination.players.ids,
   (data, ids) => filterByKeys(data, ids)
);

export const selectRatedPlayers = createSelector(
   (state) => state.model.ratedPlayers,
   (state) => state.pagination.ratedPlayers.ids,
   (data, ids) => filterByKeys(data, ids)
);

import { createSelector } from 'reselect';
import { filterByKeys } from 'players/selectors/utils';

/**
 * Returns all the players.
 */
export const selectPlayers = createSelector(
   (state) => state.model.players,
   (state) => state.pagination.players.ids,
   (data, ids) => filterByKeys(data, ids)
);

/**
 * Returns all the rated players.
 */
export const selectRatedPlayers = createSelector(
   (state) => state.model.ratedPlayers,
   (state) => state.pagination.ratedPlayers.ids,
   (data, ids) => filterByKeys(data, ids)
);

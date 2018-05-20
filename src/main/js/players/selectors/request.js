import { selectLastPlayerPage, selectLastRatedPlayerPage } from 'players/selectors/page';

/**
 * Returns the flag marking if the players are being fetched.
 */
export const selectPlayerIsFetching = (state) => state.pagination.players.isFetching;

/**
 * Returns a flag marking if the players can be loaded.
 */
export const selectCanLoadPlayer = (state) => !selectLastPlayerPage(state) && !selectPlayerIsFetching(state);

/**
 * Returns the flag marking if the rated players are being fetched.
 */
export const selectRatedPlayerIsFetching = (state) => state.pagination.ratedPlayers.isFetching;

/**
 * Returns a flag marking if the rated players can be loaded.
 */
export const selectCanLoadRatedPlayer = (state) => !selectLastRatedPlayerPage(state) && !selectRatedPlayerIsFetching(state);


/**
 * Returns the number of the current players page.
 */
export const selectCurrentPlayerPage = (state) => state.pagination.players.page;

/**
 * Returns the number of the last players page.
 */
export const selectLastPlayerPage = (state) => state.pagination.players.last;

/**
 * Returns the number of the current rated players page.
 */
export const selectCurrentRatedPlayerPage = (state) => state.pagination.ratedPlayers.page;

/**
 * Returns the number of the last rated players page.
 */
export const selectLastRatedPlayerPage = (state) => state.pagination.ratedPlayers.last;

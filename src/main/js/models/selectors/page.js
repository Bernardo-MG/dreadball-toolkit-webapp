
export const selectCurrentPlayerPage = (state) => state.pagination.players.page;

export const selectLastPlayerPage = (state) => state.pagination.players.last;

export const selectCurrentPlayerPageVisual = (state) => state.pagination.players.page + 1;

export const selectTotalPlayerPages = (state) => state.pagination.players.totalPages;

export const selectCurrentRatedPlayerPage = (state) => state.pagination.ratedPlayers.page;

export const selectLastRatedPlayerPage = (state) => state.pagination.ratedPlayers.last;

import { selectLastPlayerPage, selectLastRatedPlayerPage } from 'models/selectors/page';

export const selectPlayerIsFetching = (state) => state.pagination.players.isFetching;

export const selectCanLoadPlayer = (state) => !selectLastPlayerPage(state) && !selectIsFetchingPlayer(state);

export const selectRatedPlayerIsFetching = (state) => state.pagination.ratedPlayers.isFetching;

export const selectCanLoadRatedPlayer = (state) => !selectLastRatedPlayerPage(state) && !selectRatedPlayerIsFetching(state);

import { takeLatest } from 'redux-saga/effects';
import * as types from 'players/actions/actionTypes';
import { requestCurrentPage, requestNextPage } from 'players/sagas/affinityPlayers/requests';
import { build } from 'players/sagas/affinityPlayers/creators';

export const affinityPlayerSagas = [
   takeLatest(types.REQUEST_TEAM_PLAYERS, requestCurrentPage),
   takeLatest(types.REQUEST_SUCCESS_TEAM_PLAYERS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_TEAM_PLAYERS, requestNextPage)
];

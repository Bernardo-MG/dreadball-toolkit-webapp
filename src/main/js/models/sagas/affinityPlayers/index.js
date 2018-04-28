import { takeLatest } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { requestCurrentPage, requestNextPage } from 'models/sagas/affinityPlayers/requests';
import { build } from 'models/sagas/affinityPlayers/builders';

export const affinityPlayersagas = [
   takeLatest(types.REQUEST_TEAM_PLAYERS, requestCurrentPage),
   takeLatest(types.REQUEST_SUCCESS_TEAM_PLAYERS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_TEAM_PLAYERS, requestNextPage)
];

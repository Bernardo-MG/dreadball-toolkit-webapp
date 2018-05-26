import { takeLatest } from 'redux-saga/effects';
import * as types from 'players/actions/actionTypes';
import { requestCurrentPage, requestNextPage } from 'players/sagas/players/requests';
import { build } from 'players/sagas/players/creators';

export const playerSagas = [
   takeLatest(types.REQUEST_PLAYERS, requestCurrentPage),
   takeLatest(types.REQUEST_SUCCESS_PLAYERS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_PLAYERS, requestNextPage)
];

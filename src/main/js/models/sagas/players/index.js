import { put, takeLatest } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { requestCurrentPage, requestNextPage } from 'models/sagas/players/requests';
import { build } from 'models/sagas/players/builders';

export const playerSagas = [
   takeLatest(types.REQUEST_PLAYERS, requestCurrentPage),
   takeLatest(types.REQUEST_SUCCESS_PLAYERS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_PLAYERS, requestNextPage)
];

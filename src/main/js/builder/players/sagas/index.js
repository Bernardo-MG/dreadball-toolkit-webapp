import { takeLatest } from 'redux-saga/effects';
import * as types from 'players/actions/actionTypes';
import { requestCurrentPage, requestNextPage } from 'builder/players/sagas/requests';
import { build } from 'builder/players/sagas/creators';

export const ratedPlayerSagas = [
   takeLatest(types.REQUEST_TEAM_PLAYERS, requestCurrentPage),
   takeLatest(types.REQUEST_SUCCESS_TEAM_PLAYERS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_TEAM_PLAYERS, requestNextPage)
];

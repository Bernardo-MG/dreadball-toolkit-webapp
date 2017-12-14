import { put, takeLatest, call } from 'redux-saga/effects';
import * as types from 'builder/actions/ActionTypes';
import { avasValidationFetcher as fetcher } from 'builder/requests/fetchers';

function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const payload = yield call(fetch, action.params);
   yield put({ type: types.REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION_AFFINITIES, ...payload });
}

function* build(action) {
   yield put({ type: types.SET_BASE_RANK, payload: action.payload });
   yield put({ type: types.SET_RANK, payload: action.payload });
}

export const affinitiesSagas = [
   takeLatest(types.TEAM_AFFINITIES_VALIDATION, request),
   takeLatest(types.REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION_AFFINITIES, build)
];

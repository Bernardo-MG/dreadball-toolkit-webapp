import { put, takeLatest, call } from 'redux-saga/effects';
import * as types from 'builder/actions/ActionTypes';
import { avasValidationFetcher as fetcher } from 'builder/requests/fetchers';

function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const payload = yield call(fetch, action.params);
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION_AFFINITIES', ...payload });
   yield put({ type: types.SET_BASE_RANK, ...payload });
   yield put({ type: types.SET_RANK, ...payload });
}

function* build(action) {
   yield put({ type: types.SET_BASE_RANK, payload: action.payload });
   yield put({ type: types.SET_RANK, payload: action.payload });
}

export const affinitiesSagas = [
   takeLatest('SPONSOR_TEAM_VALIDATION_AFFINITIES', request),
   takeLatest('REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION_AFFINITIES', build)
];

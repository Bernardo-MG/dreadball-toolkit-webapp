import { put, takeLatest, call } from 'redux-saga/effects';
import * as types from 'builder/actions/ActionTypes';
import { avasValidationFetcher as fetcher } from 'builder/affinities/requests/fetchers';
import { validationSuccess } from 'builder/actions';

function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const response = yield call(fetch, action.params);
   yield put(validationSuccess(response.payload));
}

function* build(action) {
   yield put({ type: types.SET_BASE_RANK, payload: action.payload.baseRank });
   yield put({ type: types.SET_RANK, payload: action.payload.rank });
}

export const affinitiesSagas = [
   takeLatest(types.TEAM_AFFINITIES_VALIDATION, request),
   takeLatest(types.REQUEST_SUCCESS_TEAM_VALIDATION_AFFINITIES, build)
];

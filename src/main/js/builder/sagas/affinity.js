import { put, takeLatest, call } from 'redux-saga/effects';
import * as types from 'builder/actions/ActionTypes';
import { avasValidationFetcher } from 'builder/requests/fetchers';

function fetchValidateAvas(params) {
   return avasValidationFetcher.fetch(params);
}

function* requestValidateAffAvas(action) {
   const payload = yield call(fetchValidateAvas, action.params);
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION_AFFINITIES', ...payload });
   yield put({ type: types.SET_BASE_RANK, ...payload });
   yield put({ type: types.SET_RANK, ...payload });
}

export const affinitiesSagas = [
   takeLatest('SPONSOR_TEAM_VALIDATION_AFFINITIES', requestValidateAffAvas)
];

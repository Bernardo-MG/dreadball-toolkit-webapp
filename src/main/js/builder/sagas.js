import { put, takeLatest, call } from 'redux-saga/effects';
import * as types from 'builder/actions/ActionTypes';
import { teamValidationFetcher, avasValidationFetcher } from 'builder/requests/fetchers';

function fetchValidateAvas(params) {
   return avasValidationFetcher.fetch(params);
}

function fetchValidateTeam(params) {
   return teamValidationFetcher.fetch(params);
}

function* requestValidateAffAvas(action) {
   const payload = yield call(fetchValidateAvas, { ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION_AFFINITIES', ...payload });
   yield put({ type: types.SET_BASE_RANK, ...payload });
   yield put({ type: types.SET_RANK, ...payload });
}

function* requestValidateTeam(action) {
   const payload = yield call(fetchValidateTeam, { ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION', ...payload });
   yield put({ type: types.SET_BASE_RANK, ...payload });
   yield put({ type: types.SET_RANK, ...payload });
   yield put({ type: types.SET_TEAM_VALUE, ...payload });
   yield put({ type: types.SET_SPONSOR_UNITS, ...payload });
}

export function* validateAffAvas() {
   yield takeLatest('SPONSOR_TEAM_VALIDATION_AFFINITIES', requestValidateAffAvas);
}

export function* validateTeam() {
   yield takeLatest('SPONSOR_TEAM_VALIDATION', requestValidateTeam);
}

export function* chooseUnitAndValidateTeam() {
   yield takeLatest('CHOOSE_SPONSOR_UNIT', requestValidateTeam);
}

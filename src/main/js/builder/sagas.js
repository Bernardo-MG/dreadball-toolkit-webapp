import { put, takeLatest, call } from 'redux-saga/effects';
import { BUILDER_VALIDATION_REST_ENDPOINT as validationEndpoint, BUILDER_VALIDATION_AFFINITIES_REST_ENDPOINT as validationAffinitiesEndpoint } from 'builder/requests/Endpoints';
import * as types from 'builder/actions/ActionTypes';
import { Fetcher } from 'api/fetch';
import { appendBase } from 'utils';

const fullValidationAffinitiesEndpoint = appendBase(validationAffinitiesEndpoint);

const fullValidationEndpoint = appendBase(validationEndpoint);

const avasValidationFetcher = new Fetcher(fullValidationAffinitiesEndpoint);

const teamValidationFetcher = new Fetcher(fullValidationEndpoint);

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
}

export function* validateAffAvas() {
   yield takeLatest('SPONSOR_TEAM_VALIDATION_AFFINITIES', requestValidateAffAvas);
}

export function* validateTeam() {
   yield takeLatest('SPONSOR_TEAM_VALIDATION', requestValidateTeam);
}

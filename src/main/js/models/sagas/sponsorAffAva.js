import { put, takeLatest, call } from 'redux-saga/effects';
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { BUILDER_VALIDATION_AFFINITIES_REST_ENDPOINT as validationAffinitiesEndpoint } from 'builder/requests/Endpoints';
import { CREATE_AFFINITIES, CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES } from 'models/actions/ActionTypes';
import * as builderTypes from 'builder/actions/ActionTypes';
import { normalize } from 'normalizr';
import { fetchPaginated, defaultFetch } from 'api/fetch';
import { sponsorAffinityAvailability } from 'models/schema';
import { appendBase } from 'utils';

export const parse = (json) => normalize(json, [sponsorAffinityAvailability]);

const fullEndpoint = appendBase(endpoint);
const fullValidationAffinitiesEndpoint = appendBase(validationAffinitiesEndpoint);

export function fetchAvas(params) {
   return fetchPaginated(fullEndpoint, params, parse).then(
      (response) => response,
      (error) => error.message || 'Request failed'
   );
}

export function fetchValidateAvas(params) {
   return defaultFetch(fullValidationAffinitiesEndpoint, params).then(
      (response) => response,
      (error) => error.message || 'Request failed'
   );
}

function* requestAffAvas(action) {
   const payload = yield call(fetchAvas, { ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_AVAILABILITIES', ...payload });
   yield put({ type: CREATE_AFFINITIES, ...payload });
   yield put({ type: CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, ...payload });
}

function* requestValidateAffAvas(action) {
   const payload = yield call(fetchValidateAvas, { ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION_AFFINITIES', ...payload });
   yield put({ type: builderTypes.SET_BASE_RANK, ...payload });
   yield put({ type: builderTypes.SET_RANK, ...payload });
}

export function* generateAffAvas() {
   yield takeLatest('REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES', requestAffAvas);
}

export function* validateAffAvas() {
   yield takeLatest('SPONSOR_TEAM_VALIDATION_AFFINITIES', requestValidateAffAvas);
}


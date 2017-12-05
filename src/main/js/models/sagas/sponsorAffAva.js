import { put, takeLatest, call } from 'redux-saga/effects';
import { SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { CREATE_AFFINITIES, CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES } from 'models/actions/ActionTypes';
import { normalize } from 'normalizr';
import { fetchPaginated } from 'api/fetch';
import { sponsorAffinityAvailability } from 'models/schema';
import { appendBase } from 'utils';

export const parse = (json) => normalize(json, [sponsorAffinityAvailability]);

const fullEndpoint = appendBase(endpoint);

export function fetchAvas(params) {
   return fetchPaginated(fullEndpoint, params, parse).then(
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

export function* generateAffAvas() {
   yield takeLatest('REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES', requestAffAvas);
}


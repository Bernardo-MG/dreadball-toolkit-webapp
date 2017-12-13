import { put, takeLatest, call } from 'redux-saga/effects';
import * as types from 'models/actions/ActionTypes';
import { fetcherAvaAff as fetcher } from 'models/requests/fetchers';

function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const payload = yield call(fetch, { ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_AVAILABILITIES', ...payload });
}

function* build(action) {
   yield put({ type: types.CREATE_AFFINITIES, payload: action.payload });
   yield put({ type: types.CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, payload: action.payload });
}

export const affAvasSagas = [
   takeLatest('REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES', request),
   takeLatest('REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_AVAILABILITIES', build)
];

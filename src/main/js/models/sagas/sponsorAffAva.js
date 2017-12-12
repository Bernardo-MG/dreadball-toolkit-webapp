import { put, takeLatest, call } from 'redux-saga/effects';
import * as types from 'models/actions/ActionTypes';
import { fetcherAvaAff as fetcher } from 'models/requests/fetchers';

function fetchAvas(params) {
   return fetcher.fetch(params);
}

function* requestAffAvas(action) {
   const payload = yield call(fetchAvas, { ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_AVAILABILITIES', ...payload });
   yield put({ type: types.CREATE_AFFINITIES, ...payload });
   yield put({ type: types.CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, ...payload });
}

export const affAvasSagas = [
   takeLatest('REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES', requestAffAvas)
];

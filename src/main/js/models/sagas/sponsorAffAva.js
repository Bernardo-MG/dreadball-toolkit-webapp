import { put, takeLatest, call } from 'redux-saga/effects';
import * as types from 'models/actions/ActionTypes';
import { fetcherAvaAff as fetcher } from 'models/requests/fetchers';
import { requestSuccess } from 'models/actions/sponsorAffAva';

function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const response = yield call(fetch, { ...action.params });
   yield put(requestSuccess(response.payload));
}

function* build(action) {
   yield put({ type: types.CREATE_AFFINITIES, payload: action.payload });
   yield put({ type: types.CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, payload: action.payload });
}

export const affAvasSagas = [
   takeLatest(types.REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, request),
   takeLatest(types.REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_AVAILABILITIES, build)
];

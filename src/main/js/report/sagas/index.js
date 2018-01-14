import { takeLatest, call } from 'redux-saga/effects';
import * as types from 'report/actions/actionTypes';
import { fetcherReport as fetcher } from 'report/requests/fetchers';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   yield call(fetch, { ...action.params });
}

export const reportSagas = [
   takeLatest(types.REQUEST_TEAM_REPORT, request)
];

import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/ActionTypes';
import { fetcherUnit as fetcher } from 'models/requests/fetchers';
import { unitPageSelector as pageSelector } from 'models/selectors/page';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const page = yield select(pageSelector);
   const response = yield call(fetch, { page, ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_UNITS', ...response });
}

function* build(action) {
   yield put({ type: types.CREATE_ABILITIES, payload: action.payload });
   yield put({ type: types.CREATE_AFFINITIES, payload: action.payload });
   yield put({ type: types.CREATE_UNITS, payload: action.payload });
}

export const unitSagas = [
   takeLatest('REQUEST_UNITS', request),
   takeLatest('REQUEST_SUCCESS_UNITS', build),
   takeLatest('CHANGE_PAGE_NEXT_UNITS', request),
   takeLatest('CHANGE_PAGE_PREV_UNITS', request)
];

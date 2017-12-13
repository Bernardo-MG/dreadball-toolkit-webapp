import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/ActionTypes';
import { fetcherSponsorUnit as fetcher } from 'models/requests/fetchers';
import { sponsorUnitPageSelector as pageSelector } from 'models/selectors/page';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const page = yield select(pageSelector);
   const response = yield call(fetch, { page, ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_UNITS', ...response });
}

function* build(action) {
   yield put({ type: types.CREATE_ABILITIES, payload: action.payload });
   yield put({ type: types.CREATE_AFFINITIES, payload: action.payload });
   yield put({ type: types.CREATE_RATED_UNITS, payload: action.payload });
}

export const sponsorUnitSagas = [
   takeLatest('REQUEST_SPONSOR_UNITS', request),
   takeLatest('REQUEST_SUCCESS_SPONSOR_UNITS', build),
   takeLatest('CHANGE_PAGE_NEXT_SPONSOR_UNITS', request),
   takeLatest('CHANGE_PAGE_PREV_SPONSOR_UNITS', request)
];

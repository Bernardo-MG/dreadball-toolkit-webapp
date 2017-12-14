import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/ActionTypes';
import { fetcherSponsorUnit as fetcher } from 'models/requests/fetchers';
import { sponsorUnitPageSelector as pageSelector } from 'models/selectors/page';
import { requestSuccess } from 'models/actions/sponsorUnit';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const page = yield select(pageSelector);
   const response = yield call(fetch, { page, ...action.params });
   yield put(requestSuccess(response.payload, response.pagination));
}

function* build(action) {
   yield put({ type: types.CREATE_ABILITIES, payload: action.payload });
   yield put({ type: types.CREATE_AFFINITIES, payload: action.payload });
   yield put({ type: types.CREATE_RATED_UNITS, payload: action.payload });
}

export const sponsorUnitSagas = [
   takeLatest(types.REQUEST_SPONSOR_UNITS, request),
   takeLatest(types.REQUEST_SUCCESS_SPONSOR_UNITS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_SPONSOR_UNITS, request),
   takeLatest(types.CHANGE_PAGE_PREV_SPONSOR_UNITS, request)
];

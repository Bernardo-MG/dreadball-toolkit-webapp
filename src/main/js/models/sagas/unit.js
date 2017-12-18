import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { fetcherUnit as fetcher } from 'models/requests/fetchers';
import { unitPageSelector as pageSelector } from 'models/selectors/page';
import { requestSuccess } from 'models/actions/unit';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const page = yield select(pageSelector);
   const response = yield call(fetch, { page, ...action.params });
   yield put(requestSuccess(response.payload, response.pagination));
}

function* build(action) {
   yield put({ type: types.CREATE_ABILITIES, payload: action.payload.entities.abilities });
   yield put({ type: types.CREATE_AFFINITIES, payload: action.payload.entities.affinities });
   yield put({ type: types.CREATE_UNITS, payload: action.payload.entities.units });
}

export const unitSagas = [
   takeLatest(types.REQUEST_UNITS, request),
   takeLatest(types.REQUEST_SUCCESS_UNITS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_UNITS, request),
   takeLatest(types.CHANGE_PAGE_PREV_UNITS, request)
];

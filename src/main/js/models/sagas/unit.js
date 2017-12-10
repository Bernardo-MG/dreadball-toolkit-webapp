import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/ActionTypes';
import { fetcherUnit as fetcher } from 'models/requests/fetchers';
import { unitPageSelector as pageSelector } from 'models/selectors/page';

export function fetchUnits(params) {
   return fetcher.fetch(params);
}

function* requestUnits(action) {
   const page = yield select(pageSelector);
   const units = yield call(fetchUnits, { page, ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_UNITS', ...units });
   yield put({ type: types.CREATE_ABILITIES, ...units });
   yield put({ type: types.CREATE_AFFINITIES, ...units });
   yield put({ type: types.CREATE_UNITS, ...units });
}

export function* generateUnit() {
   yield takeLatest('REQUEST_UNITS', requestUnits);
}

export function* nextUnitPage() {
   yield takeLatest('CHANGE_PAGE_NEXT_UNITS', requestUnits);
}

export function* prevUnitPage() {
   yield takeLatest('CHANGE_PAGE_PREV_UNITS', requestUnits);
}

import { put, takeLatest, call, select } from 'redux-saga/effects';
import { AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS } from 'models/actions/ActionTypes';
import { normalize } from 'normalizr';
import { Fetcher } from 'api/fetch';
import { unit } from 'models/schema';
import { appendBase } from 'utils';

const parse = (json) => normalize(json, [unit]);

const fullEndpoint = appendBase(endpoint);

const fetcher = new Fetcher(fullEndpoint, parse);

const pageSelector = (state) => state.pagination.units.page;

export function fetchUnits(params) {
   return fetcher.fetch(params);
}

function* requestUnits(action) {
   const page = yield select(pageSelector);
   const units = yield call(fetchUnits, { page, ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_UNITS', ...units });
   yield put({ type: CREATE_ABILITIES, ...units });
   yield put({ type: CREATE_AFFINITIES, ...units });
   yield put({ type: CREATE_UNITS, ...units });
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


import { put, takeLatest, call, select } from 'redux-saga/effects';
import { SPONSOR_AFFINITY_UNITS_REST_ENDPOINT as endpoint } from 'models/Endpoints';
import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_RATED_UNITS } from 'models/actions/ActionTypes';
import { normalize } from 'normalizr';
import { Fetcher } from 'api/fetch';
import { unit } from 'models/schema';
import { appendBase } from 'utils';

const parse = (json) => normalize(json, [unit]);

const fullEndpoint = appendBase(endpoint);

const fetcher = new Fetcher(fullEndpoint, parse);

const pageSelector = (state) => state.pagination.units.page;

export function fetchSponsorUnits(params) {
   return fetcher.fetch(params);
}

function* requestSponsorUnits(action) {
   const page = yield select(pageSelector);
   const units = yield call(fetchSponsorUnits, { page, ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_UNITS', ...units });
   yield put({ type: CREATE_ABILITIES, ...units });
   yield put({ type: CREATE_AFFINITIES, ...units });
   yield put({ type: CREATE_RATED_UNITS, ...units });
}

export function* generateSponsorUnit() {
   yield takeLatest('REQUEST_SPONSOR_UNITS', requestSponsorUnits);
}

export function* nextSponsorUnitPage() {
   yield takeLatest('CHANGE_PAGE_NEXT_SPONSOR_UNITS', requestSponsorUnits);
}

export function* prevSponsorUnitPage() {
   yield takeLatest('CHANGE_PAGE_PREV_SPONSOR_UNITS', requestSponsorUnits);
}


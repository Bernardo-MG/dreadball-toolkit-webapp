import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/ActionTypes';
import { fetcherSponsorUnit as fetcher } from 'models/requests/fetchers';
import { sponsorUnitPageSelector as pageSelector } from 'models/selectors/page';

export function fetchSponsorUnits(params) {
   return fetcher.fetch(params);
}

function* requestSponsorUnits(action) {
   const page = yield select(pageSelector);
   const units = yield call(fetchSponsorUnits, { page, ...action.params });
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_UNITS', ...units });
   yield put({ type: types.CREATE_ABILITIES, ...units });
   yield put({ type: types.CREATE_AFFINITIES, ...units });
   yield put({ type: types.CREATE_RATED_UNITS, ...units });
}

export const sponsorUnitSagas = [
   takeLatest('REQUEST_SPONSOR_UNITS', requestSponsorUnits),
   takeLatest('CHANGE_PAGE_NEXT_SPONSOR_UNITS', requestSponsorUnits),
   takeLatest('CHANGE_PAGE_PREV_SPONSOR_UNITS', requestSponsorUnits)
];

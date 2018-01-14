import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { fetcherSponsorUnit as fetcher } from 'models/requests/fetchers';
import { selectCurrentRatedUnitPage as pageSelector } from 'models/selectors/page';
import { requestSuccess } from 'models/actions/sponsorUnit';
import { selectSponsorAffinities } from 'models/selectors';

export function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const page = yield select(pageSelector);
   const affinities = yield select(selectSponsorAffinities);

   const params = { ...action.params, affinities, page };
   const response = yield call(fetch, params);
   yield put(requestSuccess(response.payload, response.pagination));
}

function* build(action) {
   yield put({ type: types.CREATE_ABILITIES, payload: action.payload.entities.abilities });
   yield put({ type: types.CREATE_AFFINITIES, payload: action.payload.entities.affinities });
   yield put({ type: types.CREATE_RATED_UNITS, payload: action.payload.entities.units });
}

export const sponsorUnitSagas = [
   takeLatest(types.REQUEST_TEAM_UNITS, request),
   takeLatest(types.REQUEST_SUCCESS_TEAM_UNITS, build),
   takeLatest(types.CHANGE_PAGE_NEXT_TEAM_UNITS, request),
   takeLatest(types.CHANGE_PAGE_PREV_TEAM_UNITS, request)
];

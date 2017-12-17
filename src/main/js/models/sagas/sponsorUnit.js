import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'models/actions/ActionTypes';
import { fetcherSponsorUnit as fetcher } from 'models/requests/fetchers';
import { sponsorUnitPageSelector as pageSelector } from 'models/selectors/page';
import { requestSuccess } from 'models/actions/sponsorUnit';

export function fetch(params) {
   return fetcher.fetch(params);
}

const affinitiesSelection = (state) => state.builder.sponsor.affinities;

function* request(action) {
   const page = yield select(pageSelector);
   const affinities = yield select(affinitiesSelection);

   const params = { ...action.params, affinities };
   const response = yield call(fetch, { page, params });
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

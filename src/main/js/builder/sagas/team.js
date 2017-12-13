import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'builder/actions/ActionTypes';
import { teamValidationFetcher as fetcher } from 'builder/requests/fetchers';

function fetch(params) {
   return fetcher.fetch(params);
}

function* request(action) {
   const response = yield call(fetch, action.params);
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION', ...response });
}

function* build(action) {
   yield put({ type: types.SET_BASE_RANK, payload: action.payload });
   yield put({ type: types.SET_RANK, payload: action.payload });
   yield put({ type: types.SET_TEAM_VALUE, payload: action.payload });
   yield put({ type: types.SET_SPONSOR_UNITS, payload: action.payload });
}

const affinitiesSelection = (state) => state.builder.sponsor.affinities;

const unitsSelection = (state) => state.builder.sponsor.units;

const baseRankSelection = (state) => state.builder.sponsor.baseRank;

function* setUnit(action) {
   const affinities = yield select(affinitiesSelection);
   const units = yield select(unitsSelection);
   const baseRank = yield select(baseRankSelection);

   units.push(action.payload);

   const params = { affinities, units, baseRank };
   yield call(request, { params });
}

export const teamSagas = [
   takeLatest('SPONSOR_TEAM_VALIDATION', request),
   takeLatest('REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION', build),
   takeLatest('CHOOSE_SPONSOR_UNIT', setUnit)
];

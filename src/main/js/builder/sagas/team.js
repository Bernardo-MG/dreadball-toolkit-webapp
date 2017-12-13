import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'builder/actions/ActionTypes';
import { teamValidationFetcher } from 'builder/requests/fetchers';

function fetchValidateTeam(params) {
   return teamValidationFetcher.fetch(params);
}

function* requestValidateTeam(action) {
   const payload = yield call(fetchValidateTeam, action.params);
   yield put({ type: 'REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION', ...payload });
   yield put({ type: types.SET_BASE_RANK, ...payload });
   yield put({ type: types.SET_RANK, ...payload });
   yield put({ type: types.SET_TEAM_VALUE, ...payload });
   yield put({ type: types.SET_SPONSOR_UNITS, ...payload });
}

const affinitiesSelection = (state) => state.builder.sponsor.affinities;

const unitsSelection = (state) => state.builder.sponsor.units;

const baseRankSelection = (state) => state.builder.sponsor.baseRank;

function* loadUnitAndRequestValidateTeam(action) {
   const affinities = yield select(affinitiesSelection);
   const units = yield select(unitsSelection);
   const baseRank = yield select(baseRankSelection);

   units.push(action.payload);

   const params = { affinities, units, baseRank };
   yield call(requestValidateTeam, { params });
}

export const teamSagas = [
   takeLatest('SPONSOR_TEAM_VALIDATION', requestValidateTeam),
   takeLatest('CHOOSE_SPONSOR_UNIT', loadUnitAndRequestValidateTeam)
];

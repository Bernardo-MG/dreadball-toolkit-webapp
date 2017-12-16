import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'builder/actions/ActionTypes';
import { teamValidationFetcher as fetcher } from 'builder/requests/fetchers';
import { validateSponsorTeamSuccess } from 'builder/actions';

function fetch(params) {
   return fetcher.fetch(params);
}

function* requestValidation(action) {
   const response = yield call(fetch, action.params);
   yield put(validateSponsorTeamSuccess(response.payload));
}

function* build(action) {
   yield put({ type: types.SET_BASE_RANK, payload: action.payload });
   yield put({ type: types.SET_RANK, payload: action.payload });
   yield put({ type: types.SET_TEAM_VALUE, payload: action.payload });
   yield put({ type: types.SET_TEAM_UNITS, payload: action.payload });
}

const affinitiesSelection = (state) => state.builder.sponsor.affinities;

const unitsSelection = (state) => state.builder.sponsor.units;

const baseRankSelection = (state) => state.builder.sponsor.baseRank;

function* addUnit(action) {
   const affinities = yield select(affinitiesSelection);
   const units = yield select(unitsSelection);
   const baseRank = yield select(baseRankSelection);

   units.push(action.payload);

   const params = { affinities, units, baseRank };
   yield call(requestValidation, { params });
}

function* removeUnit(action) {
   const affinities = yield select(affinitiesSelection);
   const units = yield select(unitsSelection);
   const baseRank = yield select(baseRankSelection);

   units.filter((u) => u !== action.payload);

   const params = { affinities, units, baseRank };
   yield call(requestValidation, { params });
}

export const teamSagas = [
   takeLatest(types.TEAM_VALIDATION, requestValidation),
   takeLatest(types.REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION, build),
   takeLatest(types.ADD_TEAM_UNIT, addUnit),
   takeLatest(types.REMOVE_TEAM_UNIT, removeUnit)
];

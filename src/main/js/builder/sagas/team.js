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
   yield put({ type: types.SET_BASE_RANK, payload: action.payload.baseRank });
   yield put({ type: types.SET_RANK, payload: action.payload.rank });
   yield put({ type: types.SET_TEAM_VALUE, payload: action.payload.teamValue });
}

const affinitiesSelection = (state) => state.builder.sponsor.affinities;

const unitsSelection = (state) => state.builder.sponsor.units;

const baseRankSelection = (state) => state.builder.sponsor.baseRank;

function* validateTeam() {
   const affinities = yield select(affinitiesSelection);
   const units = yield select(unitsSelection);
   const baseRank = yield select(baseRankSelection);

   const params = { affinities, units, baseRank };
   yield call(requestValidation, { params });
}

export const teamSagas = [
   takeLatest(types.TEAM_VALIDATION, requestValidation),
   takeLatest(types.REQUEST_SUCCESS_SPONSOR_TEAM_VALIDATION, build),
   takeLatest(types.ADD_TEAM_UNIT, validateTeam),
   takeLatest(types.REMOVE_TEAM_UNIT, validateTeam)
];

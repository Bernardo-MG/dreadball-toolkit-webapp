import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'builder/actions/actionTypes';
import { avasValidationFetcher, avasOptionsFetcher } from 'builder/affinities/requests/fetchers';
import { validationSuccess, optionsRequestSuccess } from 'builder/actions';

import { selectChosenAffinities } from 'builder/affinities/selectors';

function fetchValidation(params) {
   return avasValidationFetcher.fetch(params);
}

function fetchOptions(params) {
   return avasOptionsFetcher.fetch(params);
}

function* requestOptions(action) {
   const response = yield call(fetchOptions, { ...action.params });
   yield put(optionsRequestSuccess(response.payload));
}

function* requestValidation(action) {
   const affinities = yield select(selectChosenAffinities);

   const response = yield call(fetchValidation, { ...action.params, affinities });
   yield put(validationSuccess(response.payload));
}

function* build(action) {
   if (action.payload) {
      yield put({ type: types.SET_BASE_RANK, payload: action.payload.rank });
      yield put({ type: types.SET_RANK, payload: action.payload.rank });
      yield put({ type: types.SET_CHOSEN_AFFINITIES, payload: action.payload.affinities });
   } else {
      console.error('Missing payload');
   }
}

function* buildOptions(action) {
   yield put({ type: types.SET_AFFINITY_OPTIONS, payload: action.payload });
}

export const affinitiesSagas = [
   takeLatest(types.REQUEST_SPONSOR_AFFINITY_GROUP_OPTIONS, requestOptions),
   takeLatest(types.REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_OPTIONS, buildOptions),
   takeLatest(types.TEAM_AFFINITIES_VALIDATION, requestValidation),
   takeLatest(types.REQUEST_SUCCESS_TEAM_VALIDATION_AFFINITIES, build)
];

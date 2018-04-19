import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'builder/actions/actionTypes';
import { avasValidationFetcher, avasOptionsFetcher } from 'builder/affinities/requests/fetchers';
import { validationSuccess, validationFailure, optionsRequestSuccess, optionsRequestFailure } from 'builder/actions';

import { selectChosenAffinities } from 'builder/affinities/selectors';

function fetchValidation(params) {
   return avasValidationFetcher.fetch(params);
}

function fetchOptions(params) {
   return avasOptionsFetcher.fetch(params);
}

function* requestOptions(action) {
   const params = { ...action.params };
   let response;
   try {
      response = yield call(fetchOptions, params);
      yield put(optionsRequestSuccess(response.payload));
   } catch (err) {
      yield put(optionsRequestFailure(err));
   }
}

function* requestValidation(action) {
   const affinities = yield select(selectChosenAffinities);
   const params = { ...action.params, affinities };

   let response;
   try {
      response = yield call(fetchValidation, params);
      yield put(validationSuccess(response.payload));
   } catch (err) {
      yield put(validationFailure(err));
   }
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

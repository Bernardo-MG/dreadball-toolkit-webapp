import { put, takeLatest, call, select } from 'redux-saga/effects';
import * as types from 'builder/actions/actionTypes';
import * as requestTypes from 'builder/requests/affinities/actions/actionTypes';
import { avasValidationFetcher } from 'builder/requests/affinities/fetchers';
import { validationSuccess, validationFailure } from 'builder/requests/affinities/actions';

import { selectChosenAffinities } from 'builder/affinities/selectors';

function fetchValidation(params) {
   return avasValidationFetcher.fetch(params);
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

export const validationSagas = [
   takeLatest(types.TEAM_AFFINITIES_VALIDATION, requestValidation),
   takeLatest(requestTypes.REQUEST_SUCCESS_TEAM_VALIDATION_AFFINITIES, build)
];

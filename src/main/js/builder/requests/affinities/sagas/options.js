import { put, takeLatest, call } from 'redux-saga/effects';
import * as types from 'builder/actions/actionTypes';
import * as requestTypes from 'builder/requests/affinities/actions/actionTypes';
import { avasOptionsFetcher } from 'builder/requests/affinities/fetchers';
import { optionsRequestSuccess, optionsRequestFailure } from 'builder/requests/affinities/actions';

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

function* buildOptions(action) {
   yield put({ type: types.SET_AFFINITY_OPTIONS, payload: action.payload });
}

export const optionsSagas = [
   takeLatest(requestTypes.REQUEST_SPONSOR_AFFINITY_GROUP_OPTIONS, requestOptions),
   takeLatest(requestTypes.REQUEST_SUCCESS_SPONSOR_AFFINITY_GROUP_OPTIONS, buildOptions)
];

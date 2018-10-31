import { put, takeLatest } from 'redux-saga/effects';
import * as types from 'builder/actions/actionTypes';
import * as requestTypes from 'builder/requests/validations/actions/actionTypes';

function* build(action) {
   if (action.payload) {
      yield put({ type: types.SET_BASE_RANK, payload: action.payload.baseRank });
      yield put({ type: types.SET_RANK, payload: action.payload.currentRank });
      yield put({ type: types.SET_TOTAL_COST, payload: action.payload.totalCost });
   } else {
      console.error('Missing payload');
   }
}

export const buildSagas = [
   takeLatest(requestTypes.REQUEST_SUCCESS_TEAM_VALIDATION, build)
];

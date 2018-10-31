import { put, takeLatest } from 'redux-saga/effects';
import * as types from 'players/actions/actionTypes';
import * as requestTypes from 'builder/requests/players/actions/actionTypes';

export function* build(action) {
   if (action.payload) {
      const { entities } = action.payload;

      yield put({ type: types.CREATE_ABILITIES, payload: entities.abilities });
      yield put({ type: types.CREATE_RATED_PLAYERS, payload: entities.players });
   } else {
      console.error('Missing payload');
   }
}

export const buildSagas = [
   takeLatest(requestTypes.REQUEST_SUCCESS_RATED_PLAYERS, build)
];

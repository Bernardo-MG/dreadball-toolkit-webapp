import { put, takeLatest } from 'redux-saga/effects';
import * as types from 'models/actions/actionTypes';
import { requestCurrentPage, requestNextPage } from 'models/sagas/players/requests';

export function* build(action) {
   if (action.payload) {
      const entities = action.payload.entities;

      yield put({ type: types.CREATE_ABILITIES, payload: entities.abilities });
      yield put({ type: types.CREATE_AFFINITIES, payload: entities.affinities });
      yield put({ type: types.CREATE_PLAYERS, payload: entities.players });
   } else {
      console.error('Missing payload');
   }
}

import { put } from 'redux-saga/effects';
import * as types from 'players/actions/actionTypes';

export function* build(action) {
   if (action.payload) {
      const entities = action.payload.entities;

      yield put({ type: types.CREATE_ABILITIES, payload: entities.abilities });
      yield put({ type: types.CREATE_RATED_PLAYERS, payload: entities.players });
   } else {
      console.error('Missing payload');
   }
}

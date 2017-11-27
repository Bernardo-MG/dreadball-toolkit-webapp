import { put } from 'redux-saga/effects';

export function* generateUnitSaga() {
   yield put({ type: 'ACTION' });
}

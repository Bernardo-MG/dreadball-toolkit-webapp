import { put, takeLatest } from 'redux-saga/effects';

function* requestUnits() {
   console.log('Fetching data');
   yield put({ type: 'ACTION' });
}

export function* generateUnitSaga() {
   yield takeLatest('CHOOSE_SPONSOR_AFFINITY', requestUnits);
}

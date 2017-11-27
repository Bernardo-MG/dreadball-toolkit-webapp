import { generateUnitSaga } from 'models/sagas/unit';
import { fork, all } from 'redux-saga/effects';

export default function* root() {
   yield all([
      fork(generateUnitSaga)
   ]);
}

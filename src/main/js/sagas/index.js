import { generateUnitSaga } from 'models/sagas/unit';
import { fork } from 'redux-saga/effects';

export default function* rootSaga() {
   yield [
      fork(generateUnitSaga)
   ];
}

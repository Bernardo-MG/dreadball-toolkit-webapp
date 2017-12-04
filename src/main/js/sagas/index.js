import { generateUnit, nextUnitPage, prevUnitPage } from 'models/sagas/unit';
import { fork } from 'redux-saga/effects';

export default function* rootSaga() {
   yield [
      fork(generateUnit),
      fork(nextUnitPage),
      fork(prevUnitPage)
   ];
}

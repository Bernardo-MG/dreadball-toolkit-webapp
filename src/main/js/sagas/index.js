import { modelSagas } from 'models/sagas';
import { builderSagas } from 'builder/sagas';
import { reportSagas } from 'report/sagas';
import { all } from 'redux-saga/effects';

export default function* rootSaga() {
   yield [
      all([...modelSagas, ...builderSagas, ...reportSagas])
   ];
}

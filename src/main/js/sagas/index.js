import { modelSagas } from 'players/sagas';
import { builderSagas } from 'builder/sagas';
import { reportSagas } from 'report/sagas';
import { all } from 'redux-saga/effects';

/**
 * Application redux sagas.
 * 
 * It is just a merge of all the sagas in the application.
 */
export default function* rootSaga() {
   yield [
      all([...modelSagas, ...builderSagas, ...reportSagas])
   ];
}

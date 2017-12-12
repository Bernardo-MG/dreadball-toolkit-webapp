import { unitSagas } from 'models/sagas/unit';
import { sponsorUnitSagas } from 'models/sagas/sponsorUnit';
import { affAvasSagas } from 'models/sagas/sponsorAffAva';
import { builderSagas } from 'builder/sagas';
import { all } from 'redux-saga/effects';

export default function* rootSaga() {
   yield [
      all([...unitSagas, ...sponsorUnitSagas, ...affAvasSagas, ...builderSagas])
   ];
}

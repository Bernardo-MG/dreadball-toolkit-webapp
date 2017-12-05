import { generateUnit, nextUnitPage, prevUnitPage } from 'models/sagas/unit';
import { generateSponsorUnit, nextSponsorUnitPage, prevSponsorUnitPage } from 'models/sagas/sponsorUnit';
import { generateAffAvas } from 'models/sagas/sponsorAffAva';
import { validateAffAvas, validateTeam } from 'builder/sagas';
import { fork } from 'redux-saga/effects';

export default function* rootSaga() {
   yield [
      fork(generateUnit),
      fork(nextUnitPage),
      fork(prevUnitPage),
      fork(generateSponsorUnit),
      fork(nextSponsorUnitPage),
      fork(prevSponsorUnitPage),
      fork(generateAffAvas),
      fork(validateAffAvas),
      fork(validateTeam)
   ];
}

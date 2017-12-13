import { unitSagas } from 'models/sagas/unit';
import { sponsorUnitSagas } from 'models/sagas/sponsorUnit';
import { affAvasSagas } from 'models/sagas/sponsorAffAva';

export const modelSagas = [
   ...unitSagas,
   ...sponsorUnitSagas,
   ...affAvasSagas
];

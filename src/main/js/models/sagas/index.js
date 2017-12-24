import { unitSagas } from 'models/sagas/unit';
import { sponsorUnitSagas } from 'models/sagas/sponsorUnit';

export const modelSagas = [
   ...unitSagas,
   ...sponsorUnitSagas
];

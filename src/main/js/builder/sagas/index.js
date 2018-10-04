import { validationSagas } from 'builder/validations/sagas';
import { affinitiesSagas } from 'builder/affinities/sagas';
import { ratedPlayerSagas } from 'builder/players/sagas';
import { requestSagas } from 'builder/requests/sagas';

export const builderSagas = [
   ...validationSagas,
   ...affinitiesSagas,
   ...ratedPlayerSagas,
   ...requestSagas
];

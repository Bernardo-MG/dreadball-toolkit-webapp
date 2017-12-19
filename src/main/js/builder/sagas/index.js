import { validationSagas } from 'builder/validations/sagas';
import { affinitiesSagas } from 'builder/affinities/sagas';

export const builderSagas = [
   ...validationSagas,
   ...affinitiesSagas
];

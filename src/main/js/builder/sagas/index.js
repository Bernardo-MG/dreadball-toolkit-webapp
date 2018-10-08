import { validationSagas } from 'builder/validations/sagas';
import { ratedPlayerSagas } from 'builder/players/sagas';
import { requestSagas } from 'builder/requests/sagas';

export const builderSagas = [
   ...validationSagas,
   ...ratedPlayerSagas,
   ...requestSagas
];

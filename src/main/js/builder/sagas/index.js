import { validationSagas } from 'builder/validations/sagas';
import { requestSagas } from 'builder/requests/sagas';

export const builderSagas = [
   ...validationSagas,
   ...requestSagas
];

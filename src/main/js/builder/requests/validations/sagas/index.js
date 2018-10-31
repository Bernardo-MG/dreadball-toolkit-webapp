import { buildSagas } from 'builder/requests/validations/sagas/build';
import { validationSagas } from 'builder/requests/validations/sagas/validation';

export const validationsRequestSagas = [
   ...buildSagas,
   ...validationSagas
];

import { optionsSagas } from 'builder/requests/affinities/sagas/options';
import { validationSagas } from 'builder/requests/affinities/sagas/validation';

export const affinityRequestSagas = [
   ...optionsSagas,
   ...validationSagas
];

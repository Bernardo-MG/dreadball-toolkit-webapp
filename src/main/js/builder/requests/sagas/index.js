import { affinityRequestSagas } from 'builder/requests/affinities/sagas';
import { ratedPlayerRequestSagas } from 'builder/requests/players/sagas';
import { validationsRequestSagas } from 'builder/requests/validations/sagas';

export const requestSagas = [
   ...affinityRequestSagas,
   ...ratedPlayerRequestSagas,
   ...validationsRequestSagas
];

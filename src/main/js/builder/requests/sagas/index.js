import { affinityRequestSagas } from 'builder/requests/affinities/sagas';
import { ratedPlayerSagas } from 'builder/requests/players/sagas';

export const requestSagas = [
   ...affinityRequestSagas,
   ...ratedPlayerSagas
];

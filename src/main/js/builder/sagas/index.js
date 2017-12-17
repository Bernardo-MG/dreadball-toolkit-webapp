import { teamSagas } from 'builder/sagas/team';
import { affinitiesSagas } from 'builder/affinities/sagas';

export const builderSagas = [
   ...teamSagas,
   ...affinitiesSagas
];

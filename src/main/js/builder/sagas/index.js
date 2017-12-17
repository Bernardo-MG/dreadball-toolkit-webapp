import { teamSagas } from 'builder/team/sagas';
import { affinitiesSagas } from 'builder/affinities/sagas';

export const builderSagas = [
   ...teamSagas,
   ...affinitiesSagas
];

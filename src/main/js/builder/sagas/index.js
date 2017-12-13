import { teamSagas } from 'builder/sagas/team';
import { affinitiesSagas } from 'builder/sagas/affinity';

export const builderSagas = [
   ...teamSagas,
   ...affinitiesSagas
];

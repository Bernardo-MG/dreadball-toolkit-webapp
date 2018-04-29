import { playerSagas } from 'models/sagas/players';
import { affinityPlayerSagas } from 'models/sagas/affinityPlayers';

export const modelSagas = [
   ...playerSagas,
   ...affinityPlayerSagas
];

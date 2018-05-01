import { playerSagas } from 'players/sagas/players';
import { affinityPlayerSagas } from 'players/sagas/affinityPlayers';

export const modelSagas = [
   ...playerSagas,
   ...affinityPlayerSagas
];

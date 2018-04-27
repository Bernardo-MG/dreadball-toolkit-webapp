import { playerSagas } from 'models/sagas/players';
import { sponsorPlayerSagas } from 'models/sagas/sponsorPlayers';

export const modelSagas = [
   ...playerSagas,
   ...sponsorPlayerSagas
];

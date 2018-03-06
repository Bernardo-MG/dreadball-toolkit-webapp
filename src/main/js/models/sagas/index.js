import { playerSagas } from 'models/sagas/player';
import { sponsorPlayerSagas } from 'models/sagas/sponsorPlayer';

export const modelSagas = [
   ...playerSagas,
   ...sponsorPlayerSagas
];

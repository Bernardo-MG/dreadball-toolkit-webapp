import { buildSagas } from 'builder/requests/players/sagas/build';
import { paginationSagas } from 'builder/requests/players/sagas/pages';

export const ratedPlayerRequestSagas = [
   ...buildSagas,
   ...paginationSagas
];

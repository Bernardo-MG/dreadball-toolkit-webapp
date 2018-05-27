import { normalize } from 'normalizr';
import { Fetcher } from 'api/fetch';
import { player } from 'players/schema';
import { PLAYERS_REST_ENDPOINT } from 'players/requests/endpoints';

export const fetcherPlayer = new Fetcher(PLAYERS_REST_ENDPOINT, (json) => normalize(json, [player]));

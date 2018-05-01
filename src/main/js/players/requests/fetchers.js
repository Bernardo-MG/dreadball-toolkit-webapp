import { normalize } from 'normalizr';
import { Fetcher } from 'api/fetch';
import { player } from 'players/schema';
import { TEAM_PLAYERS_REST_ENDPOINT, PLAYERS_REST_ENDPOINT } from 'players/requests/endpoints';

export const fetcherAffinityPlayer = new Fetcher(TEAM_PLAYERS_REST_ENDPOINT, (json) => normalize(json, [player]));

export const fetcherPlayer = new Fetcher(PLAYERS_REST_ENDPOINT, (json) => normalize(json, [player]));

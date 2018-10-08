import { normalize } from 'normalizr';
import { Fetcher } from 'api/fetch';
import { player } from 'players/schema';

export const TEAM_PLAYERS_REST_ENDPOINT = '/rest/builder/players';

export const fetcherAffinityPlayer = new Fetcher(TEAM_PLAYERS_REST_ENDPOINT, (json) => normalize(json, [player]));

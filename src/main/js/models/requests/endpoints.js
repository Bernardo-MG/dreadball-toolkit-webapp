import { appendBase } from 'api/utils';

const PLAYERS_REST_ENDPOINT = '/rest/players';

const TEAM_PLAYERS_REST_ENDPOINT = '/rest/builder/players';

export const sponsorPlayerEndpoint = appendBase(TEAM_PLAYERS_REST_ENDPOINT);

export const playerEndpoint = appendBase(PLAYERS_REST_ENDPOINT);

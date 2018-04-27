import { Fetcher } from 'api/fetch/file';
import { TEAM_PLAYERS_REPORT_REST_ENDPOINT } from 'report/requests/endpoints';

export const fetcherReport = new Fetcher(TEAM_PLAYERS_REPORT_REST_ENDPOINT);

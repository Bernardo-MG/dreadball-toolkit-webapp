import { appendBase } from 'api/utils';

const TEAM_PLAYERS_REPORT_REST_ENDPOINT = '/rest/builder/report';

export const teamReportEndpoint = appendBase(TEAM_PLAYERS_REPORT_REST_ENDPOINT);

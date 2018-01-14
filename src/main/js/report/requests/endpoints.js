import { appendBase } from 'api/utils';

const TEAM_UNITS_REPORT_REST_ENDPOINT = '/rest/builder/report';

export const teamReportEndpoint = appendBase(TEAM_UNITS_REPORT_REST_ENDPOINT);

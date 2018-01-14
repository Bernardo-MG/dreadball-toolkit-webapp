import { Fetcher } from 'api/fetch';
import { teamReportEndpoint } from 'report/requests/endpoints';

export const fetcherReport = new Fetcher(teamReportEndpoint);

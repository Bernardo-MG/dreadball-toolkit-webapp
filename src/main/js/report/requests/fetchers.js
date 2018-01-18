import { Fetcher } from 'api/fetch/file';
import { teamReportEndpoint } from 'report/requests/endpoints';

export const fetcherReport = new Fetcher(teamReportEndpoint);

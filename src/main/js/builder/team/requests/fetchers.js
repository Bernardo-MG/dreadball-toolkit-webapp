import { Fetcher } from 'api/fetch';
import { validationEndpoint } from 'builder/team/requests/endpoints';

export const teamValidationFetcher = new Fetcher(validationEndpoint);

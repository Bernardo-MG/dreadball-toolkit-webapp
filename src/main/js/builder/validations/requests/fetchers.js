import { Fetcher } from 'api/fetch';
import { validationEndpoint } from 'builder/validations/requests/endpoints';

export const teamValidationFetcher = new Fetcher(validationEndpoint);

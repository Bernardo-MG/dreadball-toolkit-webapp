import { Fetcher } from 'api/fetch';
import { VALIDATION_REST_ENDPOINT } from 'builder/validations/requests/endpoints';

export const teamValidationFetcher = new Fetcher(VALIDATION_REST_ENDPOINT);

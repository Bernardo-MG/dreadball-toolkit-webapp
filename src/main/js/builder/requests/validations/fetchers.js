import { Fetcher } from 'api/fetch';

export const VALIDATION_REST_ENDPOINT = '/rest/builder/validation';

export const teamValidationFetcher = new Fetcher(VALIDATION_REST_ENDPOINT);

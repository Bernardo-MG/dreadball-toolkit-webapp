import { Fetcher } from 'api/fetch';
import { VALIDATION_AFFINITIES_REST_ENDPOINT } from 'builder/affinities/requests/endpoints';

export const avasValidationFetcher = new Fetcher(VALIDATION_AFFINITIES_REST_ENDPOINT);

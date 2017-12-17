import { Fetcher } from 'api/fetch';
import { validationAffinitiesEndpoint } from 'builder/affinities/requests/endpoints';

export const avasValidationFetcher = new Fetcher(validationAffinitiesEndpoint);

import { Fetcher } from 'api/fetch';
import { validationAffinitiesEndpoint, affinityAvasOptionsEndpoint } from 'builder/affinities/requests/endpoints';

export const avasValidationFetcher = new Fetcher(validationAffinitiesEndpoint);

export const avasOptionsFetcher = new Fetcher(affinityAvasOptionsEndpoint);

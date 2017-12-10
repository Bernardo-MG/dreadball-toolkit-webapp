import { Fetcher } from 'api/fetch';
import { appendBase } from 'utils';
import { BUILDER_VALIDATION_REST_ENDPOINT as validationEndpoint, BUILDER_VALIDATION_AFFINITIES_REST_ENDPOINT as validationAffinitiesEndpoint } from 'builder/requests/endpoints';

const fullValidationAffinitiesEndpoint = appendBase(validationAffinitiesEndpoint);

const fullValidationEndpoint = appendBase(validationEndpoint);

export const avasValidationFetcher = new Fetcher(fullValidationAffinitiesEndpoint);

export const teamValidationFetcher = new Fetcher(fullValidationEndpoint);

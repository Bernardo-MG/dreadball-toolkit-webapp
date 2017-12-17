import { appendBase } from 'api/utils';

const VALIDATION_AFFINITIES_REST_ENDPOINT = '/rest/builder/validation/affinities';

export const validationAffinitiesEndpoint = appendBase(VALIDATION_AFFINITIES_REST_ENDPOINT);

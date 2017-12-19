import { appendBase } from 'api/utils';

const VALIDATION_REST_ENDPOINT = '/rest/builder/validation';

export const validationEndpoint = appendBase(VALIDATION_REST_ENDPOINT);

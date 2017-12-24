import { appendBase } from 'api/utils';

const VALIDATION_AFFINITIES_REST_ENDPOINT = '/rest/builder/validation/affinities';

const SPONSOR_AFFINITY_AVAS_OPTIONS_REST_ENDPOINT = '/rest/builder/affinity';

export const validationAffinitiesEndpoint = appendBase(VALIDATION_AFFINITIES_REST_ENDPOINT);

export const affinityAvasOptionsEndpoint = appendBase(SPONSOR_AFFINITY_AVAS_OPTIONS_REST_ENDPOINT);

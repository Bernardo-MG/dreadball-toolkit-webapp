import { Fetcher } from 'api/fetch';

const SPONSOR_AFFINITY_AVAS_OPTIONS_REST_ENDPOINT = '/rest/builder/affinity';

const VALIDATION_AFFINITIES_REST_ENDPOINT = '/rest/builder/validation/affinities';

export const avasOptionsFetcher = new Fetcher(SPONSOR_AFFINITY_AVAS_OPTIONS_REST_ENDPOINT);

export const avasValidationFetcher = new Fetcher(VALIDATION_AFFINITIES_REST_ENDPOINT);

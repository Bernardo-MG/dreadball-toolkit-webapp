import { Fetcher } from 'api/fetch';
import { VALIDATION_AFFINITIES_REST_ENDPOINT, SPONSOR_AFFINITY_AVAS_OPTIONS_REST_ENDPOINT } from 'builder/affinities/requests/endpoints';

export const avasValidationFetcher = new Fetcher(VALIDATION_AFFINITIES_REST_ENDPOINT);

export const avasOptionsFetcher = new Fetcher(SPONSOR_AFFINITY_AVAS_OPTIONS_REST_ENDPOINT);

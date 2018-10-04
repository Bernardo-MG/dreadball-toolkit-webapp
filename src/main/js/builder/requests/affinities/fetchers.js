import { Fetcher } from 'api/fetch';
import { SPONSOR_AFFINITY_AVAS_OPTIONS_REST_ENDPOINT } from 'builder/requests/affinities/endpoints';

export const avasOptionsFetcher = new Fetcher(SPONSOR_AFFINITY_AVAS_OPTIONS_REST_ENDPOINT);

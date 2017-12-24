import { normalize } from 'normalizr';
import { Fetcher } from 'api/fetch';
import { unit } from 'models/schema';
import { sponsorUnitEndpoint, unitEndpoint } from 'models/requests/endpoints';

export const fetcherSponsorUnit = new Fetcher(sponsorUnitEndpoint, (json) => normalize(json, [unit]));

export const fetcherUnit = new Fetcher(unitEndpoint, (json) => normalize(json, [unit]));

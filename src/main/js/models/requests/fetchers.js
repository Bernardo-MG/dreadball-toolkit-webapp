import { normalize } from 'normalizr';
import { Fetcher } from 'api/fetch';
import { unit, sponsorAffinityAvailability } from 'models/schema';
import { sponsorUnitEndpoint, unitEndpoint, affinityAvailabilityEndpoint } from 'models/requests/endpoints';

export const fetcherSponsorUnit = new Fetcher(sponsorUnitEndpoint, (json) => normalize(json, [unit]));

export const fetcherUnit = new Fetcher(unitEndpoint, (json) => normalize(json, [unit]));

export const fetcherAvaAff = new Fetcher(affinityAvailabilityEndpoint, (json) => normalize(json, [sponsorAffinityAvailability]));

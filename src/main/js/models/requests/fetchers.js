import { normalize } from 'normalizr';
import { Fetcher } from 'api/fetch';
import { unit, sponsorAffinityAvailability } from 'models/schema';
import { appendBase } from 'api/utils';
import { SPONSOR_AFFINITY_UNITS_REST_ENDPOINT as endpointSponsorUnit, AFFINITY_UNITS_REST_ENDPOINT as endpointUnit, SPONSOR_AFFINITY_GROUP_AVAS_REST_ENDPOINT as endpointAvaAff } from 'models/requests/endpoints';

const parseSponsorUnit = (json) => normalize(json, [unit]);

const parseUnit = (json) => normalize(json, [unit]);

const parseAvaAff = (json) => normalize(json, [sponsorAffinityAvailability]);

const fullEndpointSponsorUnit = appendBase(endpointSponsorUnit);

const fullEndpointUnit = appendBase(endpointUnit);

const fullEndpointAvaAff = appendBase(endpointAvaAff);

export const fetcherSponsorUnit = new Fetcher(fullEndpointSponsorUnit, parseSponsorUnit);

export const fetcherUnit = new Fetcher(fullEndpointUnit, parseUnit);

export const fetcherAvaAff = new Fetcher(fullEndpointAvaAff, parseAvaAff);

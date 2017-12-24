import { appendBase } from 'api/utils';

const UNITS_REST_ENDPOINT = '/rest/units';

const TEAM_UNITS_REST_ENDPOINT = '/rest/builder/units';

export const sponsorUnitEndpoint = appendBase(TEAM_UNITS_REST_ENDPOINT);

export const unitEndpoint = appendBase(UNITS_REST_ENDPOINT);

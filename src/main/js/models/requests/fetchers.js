import { normalize } from 'normalizr';
import { Fetcher } from 'api/fetch';
import { player } from 'models/schema';
import { sponsorPlayerEndpoint, playerEndpoint } from 'models/requests/endpoints';

export const fetcherSponsorPlayer = new Fetcher(sponsorPlayerEndpoint, (json) => normalize(json, [player]));

export const fetcherPlayer = new Fetcher(playerEndpoint, (json) => normalize(json, [player]));

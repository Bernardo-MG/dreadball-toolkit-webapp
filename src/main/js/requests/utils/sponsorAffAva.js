import { normalize } from 'normalizr';
import { sponsorAffinityAvailability } from 'models/schema';

export const jsonToSponsorAffinityGroupAvailabilities = (json) => normalize(json, [sponsorAffinityAvailability]);

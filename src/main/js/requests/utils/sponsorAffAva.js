import { normalize } from 'normalizr';
import { sponsorAffinityAvailability } from 'requests/schema';

export const jsonToSponsorAffinityGroupAvailabilities = (json) => ({
   return normalize(json, [sponsorAffinityAvailability]);
});

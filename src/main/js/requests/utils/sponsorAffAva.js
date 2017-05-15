import { normalize } from 'normalizr';
import { sponsorAffinityAvailability } from 'requests/schema';

export default const jsonToSponsorAffinityGroupAvailabilities = (json) => ({
   return normalize(json, [sponsorAffinityAvailability]);
});

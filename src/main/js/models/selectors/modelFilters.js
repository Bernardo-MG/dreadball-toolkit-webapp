import { filterById, filterByIdPaginated } from 'models/selectors/filters';
import { loadPlayer, loadSponsorAffAva } from 'models/selectors/loaders';

const templateNameSelector = (entity) => entity.templateName;

const nameSelector = (entity) => entity.name;

export const playerFilter = filterByIdPaginated(templateNameSelector, loadPlayer, (session) => session.Player);

export const ratedPlayerFilter = filterByIdPaginated(templateNameSelector, loadPlayer, (session) => session.RatedPlayer);

export const sponsorPlayerFilter = filterById(templateNameSelector, loadPlayer, (session) => session.RatedPlayer, (payload) => payload.map((unit) => unit.templateName));

export const sponsorAffinityAvailabilityFilter = filterByIdPaginated(nameSelector, loadSponsorAffAva, (session) => session.SponsorAffinityAvailability);

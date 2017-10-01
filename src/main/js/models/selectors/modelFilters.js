import { filterById, filterByIdPaginated, filterAll } from 'models/selectors/filters';
import { loadPlayer, loadSponsorAffAva } from 'models/selectors/loaders';

const templateNameSelector = (entity) => entity.templateName;

const nameSelector = (entity) => entity.name;

export const playerFilterPaginated = filterByIdPaginated(templateNameSelector, loadPlayer, (session) => session.Player);

export const ratedPlayerFilterPaginated = filterByIdPaginated(templateNameSelector, loadPlayer, (session) => session.RatedPlayer);

export const sponsorAffinityAvailabilityFilterPaginated = filterAll(nameSelector, loadSponsorAffAva, (session) => session.SponsorAffinityAvailability);

export const sponsorPlayerFilter = filterById(templateNameSelector, loadPlayer, (session) => session.RatedPlayer, (payload) => payload.map((unit) => unit.templateName));

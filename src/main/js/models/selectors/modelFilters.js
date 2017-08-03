import { filterById } from 'models/selectors/filters';
import { loadPlayer, loadSponsorAffAva } from 'models/selectors/loaders';

const templateNameSelector = (entity) => {
   return entity.templateName;
};

const nameSelector = (entity) => {
   return entity.name;
};

export const playerFilter = filterById(templateNameSelector, loadPlayer, (session) => session.Player);

export const ratedPlayerFilter = filterById(templateNameSelector, loadPlayer, (session) => session.RatedPlayer);

export const sponsorPlayerFilter = filterById(templateNameSelector, loadPlayer, (session) => session.RatedPlayer, payload => payload.map(unit => unit.templateName));

export const sponsorAffinityAvailabilityFilter = filterById(nameSelector, loadSponsorAffAva, (session) => session.SponsorAffinityAvailability);

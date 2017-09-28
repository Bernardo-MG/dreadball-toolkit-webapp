import { createSelector } from 'reselect';
import { createSelector as createOrmSelector } from 'redux-orm';
import orm from 'models';
import { playerFilter, ratedPlayerFilter, sponsorPlayerFilter, sponsorAffinityAvailabilityFilter } from 'models/selectors/modelFilters';

// Selects the state managed by Redux-ORM.
const ormSelector = (state) => state.orm;

const unitsSponsorOrm = createOrmSelector(
   orm,
   sponsorPlayerFilter
);

const unitsPaginatedOrm = createOrmSelector(
   orm,
   playerFilter
);

const ratedUnitsPaginatedOrm = createOrmSelector(
   orm,
   ratedPlayerFilter
);

const sponsorAffAvasPaginatedOrm = createOrmSelector(
   orm,
   sponsorAffinityAvailabilityFilter
);

export const unitsSponsor = createSelector(
   ormSelector,
   (state) => state.builder.sponsor.units,
   unitsSponsorOrm
);

export const unitsPaginated = createSelector(
   ormSelector,
   (state) => state.pagination.units,
   unitsPaginatedOrm
);

export const ratedUnitsPaginated = createSelector(
   ormSelector,
   (state) => state.pagination.ratedUnits,
   ratedUnitsPaginatedOrm
);

export const sponsorAffAvasPaginated = createSelector(
   ormSelector,
   (state) => state.pagination.sponsorAffAvas,
   sponsorAffAvasPaginatedOrm
);

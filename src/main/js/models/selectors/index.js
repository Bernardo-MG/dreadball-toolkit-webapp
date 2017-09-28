import { createSelector } from 'reselect';
import { createSelector as createOrmSelector } from 'redux-orm';
import orm from 'models';
import { playerFilterPaginated, ratedPlayerFilterPaginated, sponsorPlayerFilter, sponsorAffinityAvailabilityFilterPaginated } from 'models/selectors/modelFilters';

// Selects the state managed by Redux-ORM.
const ormSelector = (state) => state.orm;

const unitsSponsorOrm = createOrmSelector(
   orm,
   sponsorPlayerFilter
);

const unitsPaginatedOrm = createOrmSelector(
   orm,
   playerFilterPaginated
);

const ratedUnitsPaginatedOrm = createOrmSelector(
   orm,
   ratedPlayerFilterPaginated
);

const sponsorAffAvasPaginatedOrm = createOrmSelector(
   orm,
   sponsorAffinityAvailabilityFilterPaginated
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

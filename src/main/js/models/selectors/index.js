import { createSelector } from 'reselect';
import { createSelector as createOrmSelector } from 'redux-orm';
import orm from 'models';
import { playerFilter, ratedPlayerFilter, sponsorPlayerFilter, sponsorAffinityAvailabilityFilter } from 'models/selectors/modelFilters';

// Selects the state managed by Redux-ORM.
const ormSelector = (state) => state.orm;

export const unitsSponsor = createSelector(
   ormSelector,
   (state) => state.builder.sponsor.units,
   createOrmSelector(orm, sponsorPlayerFilter)
);

export const unitsPaginated = createSelector(
   ormSelector,
   (state) => state.pagination.units,
   createOrmSelector(orm, playerFilter)
);

export const ratedUnitsPaginated = createSelector(
   ormSelector,
   (state) => state.pagination.ratedUnits,
   createOrmSelector(orm, ratedPlayerFilter)
);

export const sponsorAffAvasPaginated = createSelector(
   ormSelector,
   (state) => state.pagination.sponsorAffAvas,
   createOrmSelector(orm, sponsorAffinityAvailabilityFilter)
);

import { createSelector } from 'reselect';
import { createSelector as ormCreateSelector } from 'redux-orm';
import orm from 'models';
import { playerFilter, ratedPlayerFilter, sponsorAffinityAvailabilityFilter } from 'models/selectors/modelFilters';

// Selects the state managed by Redux-ORM.
const ormSelector = (state) => {
   return state.orm;
};

export const unitsSponsor = createSelector(
   ormSelector,
   state => state.builder.sponsor.units,
   ormCreateSelector(orm, ratedPlayerFilter)
);

export const unitsPaginated = createSelector(
   ormSelector,
   state => state.pagination.units,
   ormCreateSelector(orm, playerFilter)
);

export const ratedUnitsPaginated = createSelector(
   ormSelector,
   state => state.pagination.ratedUnits,
   ormCreateSelector(orm, ratedPlayerFilter)
);

export const sponsorAffAvasPaginated = createSelector(
   ormSelector,
   state => state.pagination.sponsorAffAvas,
   ormCreateSelector(orm, sponsorAffinityAvailabilityFilter)
);

import { createSelector } from 'reselect';
import { filterByKeys, selectAllValues } from 'models/selectors/utils';

export const selectUnits = (state) => selectAllValues(state.model.units);

export const selectRatedUnits = createSelector(
   (state) => state.model.ratedUnits,
   (state) => state.pagination.ratedUnits.ids,
   (data, ids) => filterByKeys(data, ids)
);

export const selectSponsorAffinities = (state) => state.builder.affinities.chosen;

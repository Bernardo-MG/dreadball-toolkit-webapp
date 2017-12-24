import { createSelector } from 'reselect';
import { filterByKeys } from 'models/selectors/utils';

export const selectUnits = createSelector(
   (state) => state.model.units,
   (state) => state.pagination.units.ids,
   (data, ids) => filterByKeys(data, ids)
);

export const selectRatedUnits = createSelector(
   (state) => state.model.ratedUnits,
   (state) => state.pagination.ratedUnits.ids,
   (data, ids) => filterByKeys(data, ids)
);

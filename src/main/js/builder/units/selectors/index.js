import { createSelector } from 'reselect';
import { filterByKeys } from 'models/selectors/utils';

export const selectUnits = (state) => state.builder.sponsor.units;

export const selectSponsorRatedUnits = createSelector(
   (state) => state.model.ratedUnits,
   (state) => state.builder.sponsor.units,
   (data, ids) => filterByKeys(data, ids)
);

import { createSelector } from 'reselect';

const filterByKeys = (data, keys) => {
   const result = [];

   keys.forEach((k) => {
      if (k in data) {
         result.push(data[k]);
      }
   });

   return result;
};

export const unitsSponsor = createSelector(
   (state) => state.builder.sponsor.units,
   (data) => Object.values(data)
);

export const unitsPaginated = createSelector(
   (state) => state.model.units,
   (state) => state.pagination.units.ids,
   (data, ids) => filterByKeys(data, ids)
);

export const ratedUnitsPaginated = createSelector(
   (state) => state.model.ratedUnits,
   (state) => state.pagination.ratedUnits.ids,
   (data, ids) => filterByKeys(data, ids)
);

export const sponsorAffAvasPaginated = createSelector(
   (state) => state.model.sponsorAffinityAvailabilities,
   (data) => Object.values(data)
);

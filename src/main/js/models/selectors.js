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

export const selectSponsorAffAvas = createSelector(
   (state) => state.model.sponsorAffinityAvailabilities,
   (data) => Object.values(data)
);

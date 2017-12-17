import { createSelector } from 'reselect';
import { filterByKeys } from 'models/selectors/utils';

const affinityToMap = (affinity) => {
   return {
      label: affinity,
      affinity,
      value: affinity,
      rank: false
   };
};

const avaToMap = (ava) => {
   const result = ava.affinityGroups.map((affinity) => affinityToMap(affinity));

   if (ava.includingRankIncrease) {
      result.push({
         label: 'rank_increase',
         affinity: undefined,
         value: 'rank_increase',
         rank: true
      });
   }

   return result;
};

const avasToMap = (avas) => avas.map((ava) => avaToMap(ava));

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

export const selectSponsorAffAvasAsMaps = (state) => avasToMap(selectSponsorAffAvas(state));

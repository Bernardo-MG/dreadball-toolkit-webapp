
const avaToMap = (ava) => {
   const result = ava.affinityGroups.map((affinity) => {
      return {
         label: affinity,
         affinity,
         value: affinity,
         rank: false
      };
   });

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

export const avasToMap = (avas) => {
   return avas.map((ava) => {
      return avaToMap(ava);
   });
};


export const loadPlayer = (unit) => {
   const obj = Object.assign({}, unit.ref);

   if (unit.abilities) {
      obj.abilities = unit.abilities.toRefArray().map(ability => ability.name);
   }

   return obj;
};

export const loadSponsorAffAva = (ava) => {
   const obj = Object.assign({}, ava.ref);

   if (ava.affinityGroups) {
      obj.affinityGroups = ava.affinityGroups.toRefArray().map(affinity => affinity.name);
   }

   return obj;
};

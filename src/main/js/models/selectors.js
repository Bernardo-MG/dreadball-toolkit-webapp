import { createSelector } from 'reselect';
import { createSelector as ormCreateSelector } from 'redux-orm';
import orm from 'models';
import { filterPaginated } from 'pagination/utils';

// Selects the state managed by Redux-ORM.
const ormSelector = state => state.orm;

const loadUnit = (unit) => {
   const obj = Object.assign({}, unit.ref);

   if (unit.abilities) {
      obj.abilities = unit.abilities.toRefArray().map(ability => ability.name);
   }

   return obj;
};

const loadSponsorAffAva = (ava) => {
   const obj = Object.assign({}, ava.ref);

   if (ava.affinityGroups) {
      obj.affinityGroups = ava.affinityGroups.toRefArray().map(affinity => affinity.name);
   }

   return obj;
};

export const units = createSelector(
   ormSelector,
   state => state.pagination.units,
   ormCreateSelector(orm, filterPaginated((session) => session.Player, (entity) => entity.templateName, loadUnit))
);

export const sponsorAffAvas = createSelector(
   ormSelector,
   state => state.pagination.sponsorAffAvas,
   ormCreateSelector(orm, filterPaginated((session) => session.SponsorAffinityAvailability, (entity) => entity.name, loadSponsorAffAva))
);

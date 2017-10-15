import { CREATE_ABILITIES, CREATE_AFFINITIES, CREATE_UNITS, CREATE_RATED_UNITS, CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES } from 'models/actions/ActionTypes';
import orm from 'models';
import { forEachValue } from 'utils';

const model = (state, action) => {
   const session = orm.session(state);

   const { type, payload } = action;

   switch (type) {
   case CREATE_SPONSOR_AFFINITY_GROUP_AVAILABILITIES: {
      const avas = payload.entities.sponsorAffinityAvailabilities;

      forEachValue(avas,
         (ava) => {
            if (!session.SponsorAffinityAvailability.filter({ name: ava.name }).exists()) {
               session.SponsorAffinityAvailability.create(ava);
            }
         }
      );

      break;
   }
   case CREATE_ABILITIES: {
      const abilities = payload.entities.abilities;

      if (abilities) {
         // Creates abilities
         forEachValue(abilities,
            (ability) => {
               if (!session.Ability.filter({ name: ability.name }).exists()) {
                  session.Ability.create(ability);
               }
            }
         );
      }

      break;
   }
   case CREATE_AFFINITIES: {
      const affinities = payload.entities.affinities;

      if (affinities) {
         forEachValue(affinities,
            (affinity) => {
               if (!session.Affinity.filter({ name: affinity.name }).exists()) {
                  session.Affinity.create(affinity);
               }
            }
         );
      }

      break;
   }
   case CREATE_UNITS: {
      const units = payload.entities.units;

      forEachValue(units,
         (unit) => {
            if (!session.Player.filter({ templateName: unit.templateName }).exists()) {
               session.Player.create(unit);
            }
         }
      );

      break;
   }
   case CREATE_RATED_UNITS: {
      const units = payload.entities.units;

      forEachValue(units,
         (unit) => {
            if (!session.RatedPlayer.filter({ templateName: unit.templateName }).exists()) {
               session.RatedPlayer.create(unit);
            }
         }
      );

      break;
   }
   default:
   }
   return session.state;
};

export default model;

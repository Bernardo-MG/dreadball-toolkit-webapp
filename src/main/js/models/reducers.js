import { REQUEST_UNITS_SUCCESS, REQUEST_SPONSOR_UNITS_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS } from 'models/actions/ActionTypes';
import orm from 'models';
import { forEachValue } from 'utils';

const model = (state, action) => {
   const session = orm.session(state);

   const { type, payload } = action;

   switch (type) {
   case REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS: {
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
   case REQUEST_UNITS_SUCCESS: {
      // Gathers abilities sets
      const abilities = payload.entities.abilities;
      const affinities = payload.entities.affinities;

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

      if (affinities) {
         forEachValue(affinities,
            (affinity) => {
               if (!session.Affinity.filter({ name: affinity.name }).exists()) {
                  session.Affinity.create(affinity);
               }
            }
         );
      }

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
   case REQUEST_SPONSOR_UNITS_SUCCESS: {
      // Gathers abilities sets
      const abilities = payload.entities.abilities;
      const affinities = payload.entities.affinities;

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

      if (affinities) {
         forEachValue(affinities,
            (affinity) => {
               if (!session.Affinity.filter({ name: affinity.name }).exists()) {
                  session.Affinity.create(affinity);
               }
            }
         );
      }

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

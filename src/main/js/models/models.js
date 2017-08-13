import { Model, many, attr } from 'redux-orm';
import { REQUEST_UNITS_SUCCESS, REQUEST_SPONSOR_UNITS_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS } from 'requests/actions/ActionTypes';
import propTypesMixin from 'redux-orm-proptypes';
import { forEachValue } from 'utils';

const ValidatingModel = propTypesMixin(Model);

export class Ability extends Model {
   static reducer(action, AbilityModel) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_UNITS_SUCCESS:
      case REQUEST_SPONSOR_UNITS_SUCCESS: {
         // Gathers abilities sets
         const abilities = payload.entities.abilities;
         // Creates abilities
         forEachValue(abilities,
               (ability) => {
                  if (!AbilityModel.filter({ name: ability.name }).exists()) {
                     AbilityModel.create(ability);
                  }
               }
         );
         break;
      }
      default:
      }
   }
}
Ability.modelName = 'Ability';
Ability.options = {
   idAttribute: 'name'
};

export class Affinity extends Model {
   static reducer(action, AffinityModel) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_UNITS_SUCCESS:
      case REQUEST_SPONSOR_UNITS_SUCCESS:
      case REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS: {
         const affinities = payload.entities.affinities;
         if (affinities) {
            forEachValue(affinities,
                  (affinity) => {
                     if (!AffinityModel.filter({ name: affinity.name }).exists()) {
                        AffinityModel.create(affinity);
                     }
                  }
            );
         }
         break;
      }
      default:
      }
   }
}
Affinity.modelName = 'Affinity';
Affinity.options = {
   idAttribute: 'name'
};

export class SponsorAffinityAvailability extends Model {
   static reducer(action, AvailabilityModel) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS: {
         const avas = payload.entities.sponsorAffinityAvailabilities;
         forEachValue(avas,
               (ava) => {
                  if (!AvailabilityModel.filter({ name: ava.name }).exists()) {
                     AvailabilityModel.create(ava);
                  }
               }
         );
         break;
      }
      default:
      }
   }
}
SponsorAffinityAvailability.modelName = 'SponsorAffinityAvailability';
SponsorAffinityAvailability.fields = {
   name: attr(),
   includingRankIncrease: attr(),
   affinityGroups: many('Affinity', 'sponsorAvaAffinityGroups')
};
SponsorAffinityAvailability.options = {
   idAttribute: 'name'
};

export class Player extends ValidatingModel {
   static reducer(action, PlayerModel) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_UNITS_SUCCESS: {
         const units = payload.entities.units;
         forEachValue(units,
               (unit) => {
                  if (!PlayerModel.filter({ templateName: unit.templateName }).exists()) {
                     PlayerModel.create(unit);
                  }
               }
         );
         break;
      }
      default:
      }
   }
}
Player.modelName = 'Player';
Player.fields = {
   name: attr(),
   role: attr(),
   movement: attr(),
   strength: attr(),
   speed: attr(),
   skill: attr(),
   armor: attr(),
   stranger_cost: attr(),
   ally_cost: attr(),
   friend_cost: attr(),
   cost: attr(),
   abilities: many('Ability', 'unitAbilities'),
   affinityGroups: many('Affinity', 'unitAffinityGroups'),
   hatedAffinityGroups: many('Affinity', 'unitHatedAffinityGroups')
};
Player.options = {
   idAttribute: 'templateName'
};

export class RatedPlayer extends ValidatingModel {
   static reducer(action, RatedPlayerModel) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_SPONSOR_UNITS_SUCCESS: {
         const units = payload.entities.units;
         forEachValue(units,
               (unit) => {
                  if (!RatedPlayerModel.filter({ templateName: unit.templateName }).exists()) {
                     RatedPlayerModel.create(unit);
                  }
               }
         );
         break;
      }
      default:
      }
   }
}
RatedPlayer.modelName = 'RatedPlayer';
RatedPlayer.fields = {
   name: attr(),
   role: attr(),
   movement: attr(),
   strength: attr(),
   speed: attr(),
   skill: attr(),
   armor: attr(),
   stranger_cost: attr(),
   ally_cost: attr(),
   friend_cost: attr(),
   cost: attr(),
   abilities: many('Ability', 'ratedPlayerAbilities'),
   affinityGroups: many('Affinity', 'ratedPlayerUnitAffinityGroups'),
   hatedAffinityGroups: many('Affinity', 'ratedPlayerUnitHatedAffinityGroups')
};
RatedPlayer.options = {
   idAttribute: 'templateName'
};

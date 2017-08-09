import { Model, many, attr } from 'redux-orm';
import { REQUEST_UNITS_SUCCESS, REQUEST_SPONSOR_UNITS_SUCCESS, REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS } from 'requests/actions/ActionTypes';
import propTypesMixin from 'redux-orm-proptypes';
import { PropTypes } from 'react';
import { forEachValue } from 'utils';

const ValidatingModel = propTypesMixin(Model);

export class Ability extends Model {
   static reducer(action, Ability) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_UNITS_SUCCESS:
      case REQUEST_SPONSOR_UNITS_SUCCESS:
         // Gathers abilities sets
         const abilities = payload.entities.abilities;
         // Creates abilities
         forEachValue(abilities,
               ability => {
                  if (!Ability.filter({ name: ability.name }).exists()) {
                     Ability.create(ability);
                  }
               }
         );
         break;
      }
   }
}
Ability.modelName = 'Ability';
Ability.options = {
   idAttribute: 'name',
};

export class Affinity extends Model {
   static reducer(action, Affinity) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_UNITS_SUCCESS:
      case REQUEST_SPONSOR_UNITS_SUCCESS:
      case REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS:
         const affinities = payload.entities.affinities;
         if (affinities) {
            forEachValue(affinities,
                  (affinity) => {
                     if (!Affinity.filter({ name: affinity.name }).exists()) {
                        Affinity.create(affinity);
                     }
                  }
            );
         }
         break;
      }
   }
}
Affinity.modelName = 'Affinity';
Affinity.options = {
   idAttribute: 'name',
};

export class SponsorAffinityAvailability extends Model {
   static reducer(action, Availability, session) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_SPONSOR_AFFINITY_GROUP_AVAILABILITIES_SUCCESS:
         const avas = payload.entities.sponsorAffinityAvailabilities;
         forEachValue(avas,
               ava => {
                  if (!Availability.filter({ name: ava.name }).exists()) {
                     Availability.create(ava);
                  }
               }
         );
         break;
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
   static reducer(action, Player, session) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_UNITS_SUCCESS:
         const units = payload.entities.units;
         forEachValue(units,
               unit => {
                  if (!Player.filter({ templateName: unit.templateName }).exists()) {
                     Player.create(unit);
                  }
               }
         );
         break;
      }
   }
}
Player.modelName = 'Player';
Player.fields = {
   name: attr(),
   role: attr(),
   move: attr(),
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
   static reducer(action, RatedPlayer, session) {
      const { type, payload } = action;
      switch (type) {
      case REQUEST_SPONSOR_UNITS_SUCCESS:
         const units = payload.entities.units;
         forEachValue(units,
               unit => {
                  if (!RatedPlayer.filter({ templateName : unit.templateName }).exists()) {
                     RatedPlayer.create(unit);
                  }
               }
         );
         break;
      }
   }
}
RatedPlayer.modelName = 'RatedPlayer';
RatedPlayer.fields = {
   name: attr(),
   role: attr(),
   move: attr(),
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

import { Model, many, attr } from 'redux-orm';

export class Ability extends Model {}
Ability.modelName = 'Ability';
Ability.options = {
   idAttribute: 'name'
};

export class Affinity extends Model {}
Affinity.modelName = 'Affinity';
Affinity.options = {
   idAttribute: 'name'
};

export class SponsorAffinityAvailability extends Model {}
SponsorAffinityAvailability.modelName = 'SponsorAffinityAvailability';
SponsorAffinityAvailability.fields = {
   name: attr(),
   includingRankIncrease: attr(),
   affinityGroups: many('Affinity', 'sponsorAvas')
};
SponsorAffinityAvailability.options = {
   idAttribute: 'name'
};

export class Player extends Model {}
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
   abilities: many('Ability', 'units'),
   affinityGroups: many('Affinity', 'units'),
   hatedAffinityGroups: many('Affinity', 'unitsHates')
};
Player.options = {
   idAttribute: 'templateName'
};

export class RatedPlayer extends Model {}
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
   abilities: many('Ability', 'ratedUnits'),
   affinityGroups: many('Affinity', 'ratedUnits'),
   hatedAffinityGroups: many('Affinity', 'ratedUnitsHates')
};
RatedPlayer.options = {
   idAttribute: 'templateName'
};

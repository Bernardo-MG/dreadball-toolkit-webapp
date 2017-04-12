import { Model, many } from 'redux-orm';
import * as types from 'constants/ActionTypes'

export class Ability extends Model {
   static reducer(state, action, Ability, session) {
      const { type, payload } = action;
      switch (type) {
      case types.CREATE_PLAYERS:
         // Gathers abilities sets
         var abilities = payload.map(player => player.abilities);
         // Merges abilities sets
         abilities = [].concat.apply([], abilities);
         // Creates abilities
         abilities.forEach(ability => Ability.create({name: ability}));
         break;
      }
   }
}
Ability.modelName = 'Ability';
Ability.backend = {
   idAttribute: 'name',
};

export class Player extends Model {
   static reducer(state, action, Player, session) {
      const { type, payload } = action;
      switch (type) {
      case types.CREATE_PLAYERS:
         payload.forEach(player => Player.create(player));
         break;
      }
   }
}
Player.modelName = 'Player';
Player.fields = {
    abilities: many('Ability', 'abilities')
};
Player.backend = {
   idAttribute: 'templateName',
};

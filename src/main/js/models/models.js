import { Model, many } from 'redux-orm';
import * as types from '../constants/ActionTypes'

export class Ability extends Model {
   static reducer(state, action, Ability, session) {
      switch (action.type) {
      case types.CREATE_PLAYERS:
         // Gathers abilities sets
         var abilities = action.payload.map(player => player.abilities);
         // Merges abilities sets
         abilities = [].concat.apply([], abilities);
         // Creates abilities
         abilities.forEach(ability => Ability.create(ability));
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
      switch (action.type) {
      case types.CREATE_PLAYERS:
         action.payload.forEach(player => Player.create(player));
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

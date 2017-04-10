import { Model, many } from 'redux-orm';
import * as types from '../constants/ActionTypes'

export class Ability extends Model {
   static reducer(state, action, Pilot, session) {
      switch (action.type) {
      case types.CREATE_PLAYERS:
         const {Ability} = session;
         
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
   static reducer(state, action, Pilot, session) {
      switch (action.type) {
      case types.CREATE_PLAYERS:
         const {Player} = session;
         
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


//const ability = new schema.Entity('abilities');

//const player = new schema.Entity('players', { 
//   abilities: [ ability ]
//});

//const playerSchema = { players: [ player ] }

//export { playerSchema };
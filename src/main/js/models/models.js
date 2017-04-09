import { Model, many } from 'redux-orm';
import * as types from '../constants/ActionTypes'

export class Ability extends Model {
   static reducer(state, action, Pilot, session) {
      switch (action.type) {
      case types.CREATE_ABILITY:
         Ability.create(action.payload);
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
      case types.CREATE_PLAYER:
         const {Player} = session;

         Player.create(action.payload);
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
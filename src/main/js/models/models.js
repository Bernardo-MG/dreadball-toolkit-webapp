import { Model, many, attr } from 'redux-orm';
import * as ActionTypes from 'constants/ActionTypes'
import propTypesMixin from 'redux-orm-proptypes';
import { PropTypes } from 'react';

const ValidatingModel = propTypesMixin(Model);

export class Ability extends Model {
   static reducer(action, Ability, session) {
      const { type, payload } = action;
      switch (type) {
      case ActionTypes.REQUEST_UNITS_SUCCESS:
         // Gathers abilities sets
         var abilities = payload.entities.map(unit => unit.abilities);
         // Merges abilities sets
         abilities = [].concat.apply([], abilities);
         // Creates abilities
         abilities.forEach(name => {
               if (!Ability.filter({ name }).exists()) {
                  Ability.create({ name })
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

export class Player extends ValidatingModel {
   static reducer(action, Player, session) {
      const { type, payload } = action;
      switch (type) {
      case ActionTypes.REQUEST_UNITS_SUCCESS:
         payload.entities.forEach(unit => {
               if (!Player.filter({ templateName : unit.templateName }).exists()) {
                  Player.create(unit)
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
   ally_cost: attr(),
   friend_cost: attr(),
   cost: attr(),
   abilities: many('Ability', 'abilities')
};
Player.options = {
   idAttribute: 'templateName',
};
//Player.propTypes = {
//   name: PropTypes.string.isRequired,
//   role: PropTypes.string.isRequired,
//   move: PropTypes.number.isRequired,
//   strength: PropTypes.number.isRequired,
//   speed: PropTypes.number.isRequired,
//   skill: PropTypes.number.isRequired,
//   armor: PropTypes.number.isRequired,
//   stranger_cost: PropTypes.number,
//   ally_cost: PropTypes.number,
//   ally_cost: PropTypes.number,
//   friend_cost: PropTypes.number,
//   cost: PropTypes.number,
//   abilities: PropTypes.arrayOf(PropTypes.oneOfType([
//      PropTypes.instanceOf(Ability),
//      PropTypes.string,
//   ])).isRequired,
//};

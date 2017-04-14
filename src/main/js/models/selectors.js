import { createSelector } from 'reselect';
import { createSelector as ormCreateSelector } from 'redux-orm';
import orm from 'models';

// Selects the state managed by Redux-ORM.
export const ormSelector = state => state.orm;

export const players = createSelector(
   ormSelector,
   state => state,
   ormCreateSelector(
      orm,
      session => {
         var result = session.Player.all().toModelArray();
         
         result = result.map(player => {
            const obj = Object.assign({}, player.ref);
            
            if(player.abilities) {
               obj.abilities = player.abilities.toRefArray().map(ability => ability.name);
            }
            
            return obj;
         });
         
         return result;
      }
   )
);
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
         //return orm.Player.withRefs.map(player => {
            //const obj = Object.assign({}, player.ref);
            
            //obj.abilities = player.abilities.withRefs.map(ability => ability.name);
            
            //return obj;
            //return player;
         //});
         //return orm.Player.all().toRefArray();
         //const result = orm.Player.all().toRefArray();
         var result = session.Player.all().toModelArray();
         result = result.map(player => {
            const obj = Object.assign({}, player.ref);
            if(player.abilities) {
               obj.abilities = player.abilities.toRefArray().map(ability => ability.name);
            }
            return obj;
         });
         return result;
         //return session.Player.all().toRefArray();
      }
   )
);
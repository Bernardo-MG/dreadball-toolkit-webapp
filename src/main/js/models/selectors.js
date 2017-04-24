import { createSelector } from 'reselect';
import { createSelector as ormCreateSelector } from 'redux-orm';
import orm from 'models';

// Selects the state managed by Redux-ORM.
export const ormSelector = state => state.orm;

export const units = createSelector(
   ormSelector,
   state => state.pagination.units,
   ormCreateSelector(orm, (session, pagination) => {
         var result = session.Player.all().toModelArray();
         const start = pagination.page * pagination.elements;
         const end = start + pagination.elements;
         const ids = pagination.ids.slice(start, end);
         
         result = result.filter(unit => ids.includes(unit.templateName)).map(unit => {
            const obj = Object.assign({}, unit.ref);
            
            if(unit.abilities) {
               obj.abilities = unit.abilities.toRefArray().map(ability => ability.name);
            }
            
            return obj;
         });
         
         return result;
      }
   )
);
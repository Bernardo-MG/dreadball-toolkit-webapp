import schema from 'models/schema';
import { createSelector } from 'reselect';

// Selects the state managed by Redux-ORM.
export const ormSelector = state => state.orm;

export const players = createSelector(
    ormSelector,
    schema.createSelector((orm, userId) => {
        return orm.Player.withRefs.map(player => {
            const obj = Object.assign({}, player.ref);
            
            //obj.abilities = player.abilities.withRefs.map(ability => ability.name);
            
            //return obj;
            return player;
        });
    })
);
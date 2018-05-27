import { schema } from 'normalizr';

/**
 * Ability schema.
 */
export const ability = new schema.Entity('abilities', {}, {
   idAttribute: 'name'
});

/**
 * Affinity schema.
 */
export const affinity = new schema.Entity('affinities', {}, {
   idAttribute: 'name'
});

/**
 * Player schema.
 */
export const player = new schema.Entity('players', {
   abilities: [ability],
   affinityGroups: [affinity],
   hatedAffinityGroups: [affinity]
}, {
   idAttribute: 'templateName'
});

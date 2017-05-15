import { schema } from 'normalizr';

export const ability = new schema.Entity('abilities', {}, {
   idAttribute: 'name',
});

export const affinity = new schema.Entity('affinities', {}, {
   idAttribute: 'name',
});

export const sponsorAffinityAvailability = new schema.Entity('sponsorAffinityAvailabilities', {
   affinityGroups: [affinity],
}, {
   idAttribute: 'name',
});

export const unit = new schema.Entity('units', {
   abilities: [ability],
   affinityGroups: [affinity],
   hatedAffinityGroups: [affinity],
}, {
   idAttribute: 'templateName',
});

import { normalize, schema } from 'normalizr';

const ability = new schema.Entity('abilities', {}, {
   idAttribute: 'name'
});

const affinity = new schema.Entity('affinities', {}, {
   idAttribute: 'name'
});

const unit = new schema.Entity('units', {
   abilities: [ ability ],
   affinityGroups: [ affinity ],
   hatedAffinityGroups: [ affinity ]
}, {
   idAttribute: 'templateName'
});

export const jsonToUnits = (json) => {
   return normalize(json, [unit]);
}

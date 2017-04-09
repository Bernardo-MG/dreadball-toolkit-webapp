import { schema  } from 'normalizr';

const ability = new schema.Entity('abilities');

const player = new schema.Entity('players', { 
   abilities: [ ability ]
});

const playerSchema = { players: [ player ] }

export { playerSchema };
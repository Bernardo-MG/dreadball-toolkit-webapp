import { normalize } from 'normalizr';
import { unit } from 'models/schema';

export const jsonToUnits = (json) => normalize(json, [unit]);

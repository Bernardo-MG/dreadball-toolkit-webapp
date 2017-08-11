import { normalize } from 'normalizr';
import { unit } from 'requests/schema';

export const jsonToUnits = (json) => normalize(json, [unit]);

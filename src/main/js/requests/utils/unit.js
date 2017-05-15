import { normalize } from 'normalizr';
import { unit } from 'requests/schema';

export const jsonToUnits = (json) => {
   return normalize(json, [unit]);
};

import { normalize } from 'normalizr';
import { unit } from 'requests/schema/unit';

export const jsonToUnits = (json) => {
   return normalize(json, [unit]);
}

import { normalize } from 'normalizr';
import { unit } from 'requests/schema';

export default const jsonToUnits = (json) => {
   return normalize(json, [unit]);
};

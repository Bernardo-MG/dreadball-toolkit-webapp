import { normalize } from 'normalizr';
import { unit } from 'requests/schema';

export const jsonToBuilderDefaults = (json) => {
   return normalize(json, [unit]);
};

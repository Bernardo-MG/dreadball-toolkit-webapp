import { normalize } from 'normalizr';
import { builderDefault } from 'builder/requests/schema';

export const jsonToBuilderDefaults = (json) => {
   return normalize(json, builderDefault);
};

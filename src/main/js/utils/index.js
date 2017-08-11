
export const dictionaryIds = (dict) => {
   return Object.keys(dict).filter((key) => dict.hasOwnProperty(key));
};

export const forEachValue = (dict, fn) => {
   Object.keys(dict).forEach((key) => fn(dict[key]));
};

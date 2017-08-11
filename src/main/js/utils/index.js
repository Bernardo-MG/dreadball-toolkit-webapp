
export const forEachValue = (dict, fn) => {
   Object.keys(dict).forEach((key) => fn(dict[key]));
};


export const forEachValue = (dict, fn) => {
   Object.keys(dict).forEach((key) => fn(dict[key]));
};

export const appendBase = (url) => {
   let result;

   if (url.indexOf(ROUTE_BASE) === -1) {
      result = ROUTE_BASE + url;
   } else {
      result = url;
   }

   return result;
};

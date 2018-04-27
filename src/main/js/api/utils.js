
export const appendBase = (url) => {
   let result;
   const base = ROUTE_BASE || '';

   if (url.indexOf(base) === -1) {
      result = base + url;
   } else {
      result = url;
   }

   return result;
};

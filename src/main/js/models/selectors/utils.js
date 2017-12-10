
export const filterByKeys = (data, keys) => {
   const result = [];

   keys.forEach((k) => {
      if (k in data) {
         result.push(data[k]);
      }
   });

   return result;
};

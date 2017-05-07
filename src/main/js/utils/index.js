
export const dictionaryIds = (dictionary) => {
   var keys = [];
   for (var key in dictionary) {
      if (dictionary.hasOwnProperty(key)) {
         keys.push(key);
      }
   }
   
   return keys;
}

export const forEachValue = (dict, fn) => {
   Object.keys(dict).forEach(key => fn(dict[key]));
}
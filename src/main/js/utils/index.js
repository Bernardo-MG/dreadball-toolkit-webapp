
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

export const avasToMap = (avas) => {
   var result;
   
   result = avas.map(function(ava) {
      return avaToMap(ava);
   });
   
   return result;
}

const avaToMap = (ava) => {
   var result = ava.affinityGroups.map(function(affinity) {
      return {
         label: affinity,
         value: affinity
      }
   });
   
   if(ava.includingRankIncrease){
      result.push({
         label: 'rank_increase',
         value: 'rank_increase'
      });
   }
   
   return result;
}


export const jsonToUnits = (json) => {
   var result;
   var entry;
   var mapped;
   
   result = [];
   for (var i=0; i<json.length; i++) {
      entry = json[i];
      mapped = {
         name: entry.name,
         templateName: entry.templateName,
         role: entry.role,
         move: entry.attributes.movement,
         strength: entry.attributes.strength,
         speed: entry.attributes.speed,
         skill: entry.attributes.skill,
         armor: entry.attributes.armor,
         abilities: joinAbilities(entry.abilities),
         stranger_cost: entry.strangerCost,
         ally_cost: entry.allyCost,
         friend_cost: entry.friendCost,
         cost: entry.cost
      }
      
      result.push(mapped);
   };
   
   return result;
}

const joinAbilities = (abilities) => {
   var ability;
   var name;
   var result;
   
   result = [];
   for (var i=0; i<abilities.length; i++) {
      result.push(abilities[i].name);
   }
   
   return result;
}

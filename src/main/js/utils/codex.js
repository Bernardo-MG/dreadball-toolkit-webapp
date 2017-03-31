import abilityMessages from '../i18n/ability';
import roleMessages from '../i18n/role';
import unitNameMessages from '../i18n/unitName';

export const transformAffinityUnitsJson = (json, intl) => {
   var result = [];
   var entry;
   var mapped;
   
   for (var i=0; i<json.length; i++) {
      entry = json[i];
      mapped = {
         name : intl.formatMessage(unitNameMessages[entry.name]),
         role : intl.formatMessage(roleMessages[entry.role]),
         move : entry.attributes.movement,
         strength : entry.attributes.strength,
         speed : entry.attributes.speed,
         skill : entry.attributes.skill,
         armor : entry.attributes.armor,
         abilities : joinAbilities(entry.abilities, intl),
         stranger_cost : entry.strangerCost,
         ally_cost : entry.allyCost,
         friend_cost : entry.friendCost,
         cost : entry.cost
      }
      
      result.push(mapped);
   };
   
   return result;
}

const joinAbilities = (abilities, intl) => {
   var ability;
   var result;
   
   result = [];
   for (var i=0; i<abilities.length; i++) {
      ability = abilityMessages[abilities[i].name];
      result.push(intl.formatMessage(ability));
   }
   
   return result.join(', ');
}

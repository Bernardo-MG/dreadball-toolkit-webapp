import abilityMessages from '../i18n/ability';
import roleMessages from '../i18n/role';
import unitNameMessages from '../i18n/unitName';
import { arrayOf, normalize } from 'normalizr';
import { playerSchema } from '../model/schema';

export const transformAffinityUnitsJson = (json, intl) => {
   var result = [];
   var entry;
   var mapped;
   
   for (var i=0; i<json.length; i++) {
      entry = json[i];
      mapped = {
         id: entry.templateName,
         name: intl.formatMessage(unitNameMessages[entry.name]),
         templateName: entry.templateName,
         role: intl.formatMessage(roleMessages[entry.role]),
         move: entry.attributes.movement,
         strength: entry.attributes.strength,
         speed: entry.attributes.speed,
         skill: entry.attributes.skill,
         armor: entry.attributes.armor,
         abilities: joinAbilities(entry.abilities, intl),
         stranger_cost: entry.strangerCost,
         ally_cost: entry.allyCost,
         friend_cost: entry.friendCost,
         cost: entry.cost
      }
      
      result.push(mapped);
   };
   
   return normalize({players: result}, playerSchema);
}

const joinAbilities = (abilities, intl) => {
   var ability;
   var name;
   var result;
   
   result = [];
   for (var i=0; i<abilities.length; i++) {
      name = abilities[i].name;
      ability = {
         name: intl.formatMessage(abilityMessages[name]),
         id: name
      }
      result.push(ability);
   }
   
   //return result.join(', ');
   return result;
}

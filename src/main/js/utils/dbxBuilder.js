import abilityMessages from '../i18n/ability';
import roleMessages from '../i18n/role';
import unitNameMessages from '../i18n/unitName';

export const transformSponsorAffinityGroupAvailabilitiesJson = (json, intl) => {
   var result = [];
   var entry;
   var mapped;
   
   for (var i=0; i<json.length; i++) {
      entry = json[i];
      mapped = transformAffinityGroupsJson(entry.affinityGroups);
      
      result.push(mapped);
   };
   
   return result;
}
export const transformAffinityGroupsJson = (json, intl) => {
   var result = [];
   var entry;
   var mapped;
   
   for (var i=0; i<json.length; i++) {
      entry = json[i];
      mapped = {
         value : entry.name,
         label : entry.name
      }
      
      result.push(mapped);
   };
   
   return result;
}

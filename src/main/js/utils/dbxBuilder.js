import abilityMessages from '../i18n/ability';
import roleMessages from '../i18n/role';
import affinityMessages from '../i18n/affinity';

export const transformSponsorAffinityGroupAvailabilitiesJson = (json, intl) => {
   var result = [];
   var entry;
   var mapped;
   
   for (var i=0; i<json.length; i++) {
      entry = json[i];
      mapped = transformAffinityGroupsJson(entry.affinityGroups, intl);
      
      result.push(mapped);
   };
   
   return result;
}

const transformAffinityGroupsJson = (json, intl) => {
   var result = [];
   var entry;
   var mapped;
   
   for (var i=0; i<json.length; i++) {
      entry = json[i];
      mapped = {
         label : intl.formatMessage(affinityMessages[entry.name]),
         value : entry.name
      }
      
      result.push(mapped);
   };
   
   return result;
}

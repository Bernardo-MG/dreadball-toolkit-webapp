import abilityMessages from 'i18n/ability';
import roleMessages from 'i18n/role';
import affinityMessages from 'i18n/affinity';
import builderMessages from 'i18n/teamBuilder';

export const transformSponsorAffinityGroupAvailabilitiesJson = (json, intl) => {
   var result = [];
   var entry;
   var affinities;
   var mapped;
   
   for (var i=0; i<json.length; i++) {
      entry = json[i];
      affinities = transformAffinityGroupsJson(entry.affinityGroups, intl);
   
      addRankIncrease(entry.includingRankIncrease, affinities, intl);
      
      result.push(affinities);
   };
   
   return result;
}

const transformAffinityGroupsJson = (affinityGroups, intl) => {
   var result = [];
   var entry;
   var mapped;
   
   for (var i=0; i<affinityGroups.length; i++) {
      entry = affinityGroups[i];
      mapped = {
         label : intl.formatMessage(affinityMessages[entry.name]),
         value : entry.name
      }
      
      result.push(mapped);
   };
   
   return result;
}

const addRankIncrease = (rank, affinities, intl) => {
   var mapped;
   
   if(rank){
      mapped = {
         label : intl.formatMessage(builderMessages['increase_rank_option']),
         value : 'rank'
      }
      
      affinities.push(mapped);
   }
}

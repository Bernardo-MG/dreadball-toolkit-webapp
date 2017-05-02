import abilityMessages from 'i18n/ability';
import roleMessages from 'i18n/role';
import affinityMessages from 'i18n/affinity';
import builderMessages from 'i18n/teamBuilder';

export const transformSponsorAffinityGroupAvailabilitiesJson = (json) => {
   var result = [];
   var entry;
   var affinities;
   var mapped;
   
   for (var i=0; i<json.length; i++) {
      entry = json[i];
      affinities = transformAffinityGroupsJson(entry.affinityGroups);
   
      addRankIncrease(entry.includingRankIncrease, affinities);
      
      result.push(affinities);
   };
   
   return result;
}

const transformAffinityGroupsJson = (affinityGroups) => {
   var result = [];
   var entry;
   var mapped;
   
   for (var i=0; i<affinityGroups.length; i++) {
      entry = affinityGroups[i];
      mapped = {
         label : entry.name,
         value : entry.name
      }
      
      result.push(mapped);
   };
   
   return result;
}

const addRankIncrease = (rank, affinities) => {
   var mapped;
   
   if(rank){
      mapped = {
         label : 'increase_rank_option',
         value : 'rank'
      }
      
      affinities.push(mapped);
   }
}

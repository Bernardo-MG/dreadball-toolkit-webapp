import affinitiesMessages from 'i18n/affinity';
import builderMessages from 'i18n/teamBuilder';

const affinityToMap = (affinity, intl) => {
   return {
      label: intl.formatMessage(affinitiesMessages[affinity]),
      value: affinity
   };
};

const avaToMap = (ava, intl) => {
   const result = ava.affinityGroups.map((affinity) => affinityToMap(affinity, intl));

   if (ava.rankIncrease) {
      result.push({
         label: intl.formatMessage(builderMessages.increase_rank_option),
         value: 'rank_increase'
      });
   }

   return result;
};

export const affinityOptionsFromAvas = (avas, intl) => avas.map((ava) => avaToMap(ava, intl));

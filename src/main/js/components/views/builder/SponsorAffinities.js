import React from 'react';
import ComboPanel from '../../../components/ComboPanel';

const affinities = [
   { value: 'affinity1', label: 'affinity1' },
   { value: 'affinity2', label: 'affinity2' },
   { value: 'affinity3', label: 'affinity3' },
   { value: 'affinity4', label: 'affinity4' },
   { value: 'affinity5', label: 'affinity5' },
   { value: 'affinity6', label: 'affinity6' }
];

const values = [ affinities, affinities, affinities, affinities, affinities ];

const SponsorAffinities = () => {
   return (
      <ComboPanel source={values} />
   );
};

export default SponsorAffinities;
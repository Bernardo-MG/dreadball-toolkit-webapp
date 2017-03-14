import React from 'react';
import { Button } from 'react-toolbox/lib/button';
import AffinityGroupsComboPanel from '../../../containers/AffinityGroupsComboPanel';

const SponsorAffinities = () => {
   return (
      <div>
         <AffinityGroupsComboPanel />
         <Button label='accept' raised primary />
      </div>
   );
};

export default SponsorAffinities;
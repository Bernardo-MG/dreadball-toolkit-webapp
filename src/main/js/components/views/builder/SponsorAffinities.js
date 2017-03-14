import React from 'react';
import { Button } from 'react-toolbox/lib/button';
import AffinityGroupsComboPanel from '../../../containers/AffinityGroupsComboPanel';

const clickedButton = () => {
   console.log("Clicked");
};

const SponsorAffinities = () => {
   return (
      <div>
         <AffinityGroupsComboPanel />
         <Button onClick={ clickedButton } label='accept' raised primary />
      </div>
   );
};

export default SponsorAffinities;
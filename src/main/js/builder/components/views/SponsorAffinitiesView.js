import React from 'react';
import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import AffinityGroupsComboPanel from 'builder/containers/AffinityGroupsComboPanel';

const SponsorAffinitiesView = (props) => {
   return (
      <div>
         <AffinityGroupsComboPanel />
         <Button onClick={ props.onClick } label='accept' />
      </div>
   );
};

export default SponsorAffinitiesView;

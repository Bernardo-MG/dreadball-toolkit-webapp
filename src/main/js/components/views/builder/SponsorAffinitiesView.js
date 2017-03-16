import React from 'react'
import { Button } from 'react-toolbox/lib/button';
import AffinityGroupsComboPanel from '../../../containers/AffinityGroupsComboPanel';

const SponsorAffinitiesView = (props) => {
   return (
      <div>
         <AffinityGroupsComboPanel />
         <Button onClick={ props.onClick } label='accept' raised primary />
      </div>
   );
};

export default SponsorAffinitiesView;
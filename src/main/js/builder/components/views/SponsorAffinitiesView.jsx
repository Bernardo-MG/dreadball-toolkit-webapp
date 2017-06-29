import React from 'react';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Form from 'grommet/components/Form';

import AffinityGroupsComboPanel from 'builder/containers/AffinityGroupsComboPanel';

const SponsorAffinitiesView = (props) => {
   return (
      <Form>
         <AffinityGroupsComboPanel />
         <Box margin='small'>
            <Button onClick={ props.onClick } label='accept' />
         </Box>
      </Form>
   );
};

export default SponsorAffinitiesView;

import React from 'react';

import Button from 'grommet/components/Button';
import Footer from 'grommet/components/Footer';
import Form from 'grommet/components/Form';
import Section from 'grommet/components/Section';

import AffinityGroupsComboPanel from 'builder/containers/AffinityGroupsComboPanel';

const SponsorAffinitiesView = (props) => {
   return (
      <Form>
         <AffinityGroupsComboPanel />
         <Footer>
            <Button onClick={ props.onClick } label='accept' />
         </Footer>
      </Form>
   );
};

export default SponsorAffinitiesView;

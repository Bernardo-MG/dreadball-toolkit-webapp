import React from 'react';
import Button from 'grommet/components/Button';
import AffinityGroupsComboPanel from 'builder/containers/AffinityGroupsComboPanel';
import Form from 'grommet/components/Form';
import Footer from 'grommet/components/Footer';

const SponsorAffinitiesView = (props) => {
   return (
      <div>
         <Form>
            <AffinityGroupsComboPanel />
            <Footer>
               <Button onClick={ props.onClick } label='accept' />
            </Footer>
         </Form>
      </div>
   );
};

export default SponsorAffinitiesView;

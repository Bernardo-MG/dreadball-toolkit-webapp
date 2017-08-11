import React from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Form from 'grommet/components/Form';

import AffinityGroupsComboPanel from 'builder/containers/AffinityGroupsComboPanel';

const SponsorAffinitiesView = (props) =>
   <Form>
      <AffinityGroupsComboPanel />
      <Box margin='small'>
         <Button onClick={ props.onClick } label='accept' />
      </Box>
   </Form>;

SponsorAffinitiesView.propTypes = {
   onClick: PropTypes.func.isRequired
};

export default SponsorAffinitiesView;

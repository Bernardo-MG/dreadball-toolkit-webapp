import React from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Form from 'grommet/components/Form';
import Heading from 'grommet/components/Heading';

import SponsorAffinityAvailabilitySelectionPanel from 'builder/views/containers/SponsorAffinityAvailabilitySelectionPanel';

const SponsorAffinitiesView = (props) =>
   <Form>
      <Heading>choose_affinities</Heading>
      <SponsorAffinityAvailabilitySelectionPanel />
      <Box justify='center' align='center' margin='small'>
         <Button onClick={ props.onClick } label='accept' />
      </Box>
   </Form>;

SponsorAffinitiesView.propTypes = {
   onClick: PropTypes.func.isRequired
};

export default SponsorAffinitiesView;

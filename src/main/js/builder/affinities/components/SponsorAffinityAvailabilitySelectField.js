import React from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';

import SponsorAffinityAvailabilitySelect from 'builder/affinities/containers/SponsorAffinityAvailabilitySelect';

const SponsorAffinityAvailabilitySelectField = (props) =>
   <Box>
      {props.source.map((element, i) => <SponsorAffinityAvailabilitySelect index={i} key={i} source={element} />)}
   </Box>;

SponsorAffinityAvailabilitySelectField.propTypes = {
   source: PropTypes.array.isRequired
};

export default SponsorAffinityAvailabilitySelectField;

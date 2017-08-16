import React from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Layer from 'grommet/components/Layer';

import SponsorTeamCost from 'builder/components/SponsorTeamCost';

const SponsorTeamEditionLayer = (props) =>
   <Layer closer={true} onClose={ props.onClose } >
      <Heading tag='h2'>{ props.title }</Heading>
      <SponsorTeamCost />
      <Box flex={true} pad='small'>
         {props.children}
      </Box>
   </Layer>;

SponsorTeamEditionLayer.propTypes = {
   onClose: PropTypes.func.isRequired,
   title: PropTypes.string.isRequired,
   children: PropTypes.object.isRequired
};

export default SponsorTeamEditionLayer;

import React from 'react';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Layer from 'grommet/components/Layer';

import SponsorTeamCost from 'builder/components/SponsorTeamCost';

const SponsorTeamEditionLayer = (props) => {
   return (
      <Layer closer={true} onClose={ props.onClose } >
         <Heading tag='h2'>{ props.title }</Heading>
         <SponsorTeamCost />
         <Box full={true}>
            {props.children}
         </Box>
      </Layer>
   );
};

export default SponsorTeamEditionLayer;

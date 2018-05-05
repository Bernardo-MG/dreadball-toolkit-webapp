import React from 'react';

import Box from 'grommet/components/Box';

import SponsorRankValue from 'builder/sponsors/containers/SponsorRankValue';
import SponsorTotalCost from 'builder/sponsors/containers/SponsorTotalCost';

const SponsorTeamCost = () =>
   <Box direction='row' responsive={false}>
      <Box margin='small'>
         <SponsorRankValue />
      </Box>
      <Box margin='small'>
         <SponsorTotalCost />
      </Box>
   </Box>;

export default SponsorTeamCost;

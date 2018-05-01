import React from 'react';

import Box from 'grommet/components/Box';

import SponsorRankValue from 'builder/sponsors/containers/SponsorRankValue';
import SponsorTotalCost from 'builder/sponsors/containers/SponsorTotalCost';

const SponsorTeamCost = () =>
   <Box direction='row' responsive={false}>
      <Box pad='small'>
         <SponsorRankValue />
      </Box>
      <Box pad='small'>
         <SponsorTotalCost />
      </Box>
   </Box>;

export default SponsorTeamCost;

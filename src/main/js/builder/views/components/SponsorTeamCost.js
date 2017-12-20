import React from 'react';

import Box from 'grommet/components/Box';

import SponsorRankValue from 'builder/sponsors/containers/SponsorRankValue';
import SponsorTeamValue from 'builder/sponsors/containers/SponsorTeamValue';

const SponsorTeamCost = () =>
   <Box direction='row'>
      <Box pad='small'>
         <SponsorRankValue />
      </Box>
      <Box pad='small'>
         <SponsorTeamValue />
      </Box>
   </Box>;

export default SponsorTeamCost;

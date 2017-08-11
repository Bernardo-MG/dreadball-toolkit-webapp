import React from 'react';

import Box from 'grommet/components/Box';

import SponsorRankValue from 'builder/containers/values/SponsorRankValue';
import SponsorTeamValue from 'builder/containers/values/SponsorTeamValue';

const SponsorTeamCost = () =>
   <Box direction='row'>
      <Box pad='medium'>
         <SponsorRankValue />
      </Box>
      <Box pad='medium'>
         <SponsorTeamValue />
      </Box>
   </Box>;

export default SponsorTeamCost;

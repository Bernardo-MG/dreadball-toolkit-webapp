import React from 'react';

import Box from 'grommet/components/Box';

import SponsorRankValue from 'builder/team/containers/values/SponsorRankValue';
import SponsorTeamValue from 'builder/team/containers/values/SponsorTeamValue';

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

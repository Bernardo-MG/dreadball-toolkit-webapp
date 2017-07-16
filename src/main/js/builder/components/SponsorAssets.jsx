import React from 'react';

import Box from 'grommet/components/Box';
import Columns from 'grommet/components/Columns';

import CheerleadersValue from 'builder/containers/values/CheerleadersValue';
import MediBotValue from 'builder/containers/values/MediBotValue';
import NastySurpriseCardValue from 'builder/containers/values/NastySurpriseCardValue';
import SpecialMoveCardValue from 'builder/containers/values/SpecialMoveCardValue';
import SponsorCoachingDiceValue from 'builder/containers/values/SponsorCoachingDiceValue';
import SponsorRankValue from 'builder/containers/values/SponsorRankValue';
import SponsorTeamValue from 'builder/containers/values/SponsorTeamValue';
import WagerValue from 'builder/containers/values/WagerValue';

const SponsorAssets = () => {
   return (
      <Columns>
         <Box pad='medium'>
            <SponsorCoachingDiceValue />
         </Box>
         <Box pad='medium'>
            <SpecialMoveCardValue />
         </Box>
         <Box pad='medium'>
            <NastySurpriseCardValue />
         </Box>
         <Box pad='medium'>
            <WagerValue />
         </Box>
         <Box pad='medium'>
            <MediBotValue />
         </Box>
         <Box pad='medium'>
            <CheerleadersValue />
         </Box>
      </Columns>
   );
};

export default SponsorAssets;

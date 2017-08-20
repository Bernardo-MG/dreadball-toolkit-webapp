import React from 'react';

import Box from 'grommet/components/Box';
import Columns from 'grommet/components/Columns';

import CheerleadersValue from 'builder/containers/values/CheerleadersValue';
import MediBotValue from 'builder/containers/values/MediBotValue';
import NastySurpriseCardValue from 'builder/containers/values/NastySurpriseCardValue';
import SpecialMoveCardValue from 'builder/containers/values/SpecialMoveCardValue';
import SponsorCoachingDiceValue from 'builder/containers/values/SponsorCoachingDiceValue';
import WagerValue from 'builder/containers/values/WagerValue';

const SponsorAssets = () =>
   <Columns>
      <Box pad='small'>
         <SponsorCoachingDiceValue />
      </Box>
      <Box pad='small'>
         <SpecialMoveCardValue />
      </Box>
      <Box pad='small'>
         <NastySurpriseCardValue />
      </Box>
      <Box pad='small'>
         <WagerValue />
      </Box>
      <Box pad='small'>
         <MediBotValue />
      </Box>
      <Box pad='small'>
         <CheerleadersValue />
      </Box>
   </Columns>;

export default SponsorAssets;

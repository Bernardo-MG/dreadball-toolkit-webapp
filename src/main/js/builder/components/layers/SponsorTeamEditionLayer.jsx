import React from 'react';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Heading from 'grommet/components/Heading';
import Layer from 'grommet/components/Layer';

import SponsorTeamCost from 'builder/components/SponsorTeamCost';

const SponsorTeamEditionLayer = (props) => {
   return (
      <Layer>
         <Heading tag='h2'>{ props.title }</Heading>
         <SponsorTeamCost />
         {props.children}
         <Box margin='small'>
            <Button onClick={ props.toClose } label='close' />
         </Box>
      </Layer>
   );
};

export default SponsorTeamEditionLayer;

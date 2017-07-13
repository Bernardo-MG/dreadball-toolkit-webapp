import React from 'react';

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
         <Button onClick={ props.toClose } label='close' />
      </Layer>
   );
};

export default SponsorTeamEditionLayer;

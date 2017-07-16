import React from 'react';

import Box from 'grommet/components/Box';

import SponsorAffinityComboBox from 'builder/containers/SponsorAffinityComboBox';

const SponsorAffinitySelectField = (props) => {
   return (
      <Box>
         {props.source.map((element, i) => {
            return (
               <SponsorAffinityComboBox index={i} key={i} source={element} />
            );
         })}
      </Box>
   );
};

export default SponsorAffinitySelectField;

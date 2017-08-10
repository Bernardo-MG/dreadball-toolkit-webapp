import React from 'react';

import PropTypes from 'prop-types';

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

SponsorAffinitySelectField.propTypes = {
   source: PropTypes.array.isRequired
};

export default SponsorAffinitySelectField;

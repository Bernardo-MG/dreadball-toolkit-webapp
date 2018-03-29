import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Header from 'grommet/components/Header';
import Heading from 'grommet/components/Heading';
import Title from 'grommet/components/Title';

const SimpleView = (props) => {
   const heading = 'title';

   return (
      <Box direction='column'>
         <Box direction='row'>
            <Header>
               <Title size="large" justify="between" responsive={false}>
                  {props.navButton}
                  <Heading>{heading}</Heading>
               </Title>
            </Header>
         </Box>
         {props.children}
      </Box>
   );
};

SimpleView.propTypes = {
   navButton: PropTypes.object.isRequired,
   children: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(SimpleView);

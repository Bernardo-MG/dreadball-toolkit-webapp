import React from 'react';

import PropTypes from 'prop-types';

import App from 'grommet/components/App';
import Box from 'grommet/components/Box';

import Header from 'components/layout/Header';

const BaseLayout = (props) =>
   <App centered={false}>
      <Box full={true}>
         <Header />
         {props.children}
      </Box>
   </App>;

BaseLayout.propTypes = {
   children: PropTypes.object.isRequired
};

export default BaseLayout;

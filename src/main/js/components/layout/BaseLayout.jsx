import React from 'react';

import App from 'grommet/components/App';
import Box from 'grommet/components/Box';
import Section from 'grommet/components/Section';

import Header from 'components/layout/Header';

const BaseLayout = () => {
   return (
      <App centered={false}>
         <Box full={true}>
            <Header />
            <Section primary={true} pad='small'>
               {this.props.children}
            </Section>
         </Box>
      </App>
   );
};

export default BaseLayout;

import React from 'react';
import { FormattedMessage } from 'react-intl';
import Section from 'grommet/components/Section';

const Home = () => {
   return (
      <Section primary={true} flex={true}>
         <h1><FormattedMessage id="app.main_content" defaultMessage="Main Content" description="Hello world header greeting" /></h1>
         <p>Main content goes here.</p>
      </Section>
   );
};

export default Home;
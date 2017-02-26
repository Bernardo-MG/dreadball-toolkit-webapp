import React from 'react';
import { FormattedMessage } from 'react-intl';

const Home = () => {
   return (
      <div>
         <h1><FormattedMessage id="app.main_content" defaultMessage="Main Content" description="Hello world header greeting" /></h1>
         <p>Main content goes here.</p>
      </div>
   );
};

export default Home;
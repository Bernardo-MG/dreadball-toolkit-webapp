import React from 'react';

import App from 'grommet/components/App';
import Box from 'grommet/components/Box';

import Header from 'components/layout/Header';

class BaseLayout extends React.Component {
   state = {
      drawerActive: false
   };

   toggleDrawerActive = () => {
      this.setState({ drawerActive: !this.state.drawerActive });
   };

   render() {
      return (
      <App centered={false}>
         <Box full={true}>
            <Header />
            {this.props.children}
         </Box>
      </App>
      )
   }
};

export default BaseLayout;

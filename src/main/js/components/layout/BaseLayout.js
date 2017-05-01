import React from 'react';
import App from 'grommet/components/App';
import Box from 'grommet/components/Box';
import Anchor from 'grommet/components/Anchor';
import Footer from 'grommet/components/Footer';
import Title from 'grommet/components/Title';
import Header from './Header';

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
            <Footer primary={true} appCentered={true} direction='column' align='center' pad='small' colorIndex='grey-1'>
               <p>
                  Build your ideas with <Anchor href='http://grommet.io' target='_blank'>Grommet</Anchor>!
               </p>
            </Footer>
         </Box>
      </App>
      );
   };
};

export default BaseLayout;
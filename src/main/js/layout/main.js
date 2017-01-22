import React from 'react';
import ReactDOM from 'react-dom';
import { AppBar, Navigation, Link } from 'react-toolbox';
import { Layout, NavDrawer, Panel, Sidebar } from 'react-toolbox';
import { Button } from 'react-toolbox';

import GithubIcon from './icons';

class MainLayout extends React.Component {
   state = {
         drawerActive: false
     };

   toggleDrawerActive = () => {
       this.setState({ drawerActive: !this.state.drawerActive });
   };
   
   render() {
         return (
             <Layout>
                 <NavDrawer active={this.state.drawerActive} onOverlayClick={ this.toggleDrawerActive }>
                    <Button label='Players' raised />
                 </NavDrawer>
                 <Panel>
                     <AppBar leftIcon='menu' rightIcon={<GithubIcon />} onLeftIconClick={ this.toggleDrawerActive } />
                     <div style={{ flex: 1, overflowY: 'auto', padding: '1.8rem' }}>
                        {this.props.children}
                     </div>
                 </Panel>
             </Layout>
         );
     };
};

export default MainLayout;
module.exports = MainLayout;
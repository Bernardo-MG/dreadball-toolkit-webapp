import React from 'react';
import { Layout, NavDrawer, Panel, AppBar } from 'react-toolbox';

class BaseLayout extends React.Component {
   state = {
      drawerActive: false
   };
   
   toggleDrawerActive = () => {
      this.setState({ drawerActive: !this.state.drawerActive });
   };
   
   render() {
      return (
         <Layout>
            <NavDrawer active={ this.state.drawerActive } onOverlayClick={ this.toggleDrawerActive }>
               {this.props.drawerContent}
            </NavDrawer>
            <Panel>
               <AppBar leftIcon='menu' rightIcon={ this.props.rightIcon } onLeftIconClick={ this.toggleDrawerActive } />
               <div style={{ flex: 1, overflowY: 'auto', padding: '1.8rem' }}>
                  {this.props.children}
               </div>
            </Panel>
         </Layout>
      );
   };
};

export default BaseLayout;
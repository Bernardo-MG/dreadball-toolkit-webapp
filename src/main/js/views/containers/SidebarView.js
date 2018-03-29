import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Header from 'grommet/components/Header';
import Heading from 'grommet/components/Heading';
import Split from 'grommet/components/Split';
import Title from 'grommet/components/Title';

import MenuIcon from 'grommet/components/icons/base/Menu';
import MoreIcon from 'grommet/components/icons/base/More';

import { toggleNavBar, toggleSideBar } from 'views/actions';

import { selectNavbarVisible, selectSidebarVisible, selectSmallScreen } from 'views/selectors';

const SidebarView = (props) => {
   const heading = 'title';

   let toggleNavButton;
   if (!props.navbarVisible) {
      toggleNavButton = <Button onClick={() => props.onToggleNavBar()} icon={<MenuIcon/>} />;
   }

   let toggleSideButton;
   if (!props.sidebarVisible && props.smallScreen) {
      toggleSideButton = <Button onClick={() => props.onToggleSideBar()} icon={<MoreIcon/>} />;
   }

   const priority = (props.sidebarVisible && props.smallScreen ? 'right' : 'left');

   return (
      <Split priority={priority} flex="left" separator={true} >
         <Box direction='column'>
            <Box direction='row'>
               <Header>
                  <Title size="large" justify="between" responsive={false}>
                     {toggleNavButton}
                     <Heading>{heading}</Heading>
                     {toggleSideButton}
                  </Title>
               </Header>
            </Box>
            {props.children}
         </Box>
         {props.sideBar}
      </Split>
   );
};

SidebarView.propTypes = {
   sidebarVisible: PropTypes.bool.isRequired,
   navbarVisible: PropTypes.bool.isRequired,
   smallScreen: PropTypes.bool.isRequired,
   children: PropTypes.object.isRequired,
   sideBar: PropTypes.element.isRequired,
   onToggleNavBar: PropTypes.func.isRequired,
   onToggleSideBar: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      navbarVisible: selectNavbarVisible(state),
      sidebarVisible: selectSidebarVisible(state),
      smallScreen: selectSmallScreen(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      onToggleNavBar: bindActionCreators(toggleNavBar, dispatch),
      onToggleSideBar: bindActionCreators(toggleSideBar, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SidebarView);

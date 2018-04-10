import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Header from 'grommet/components/Header';
import Split from 'grommet/components/Split';
import Title from 'grommet/components/Title';

import MenuIcon from 'grommet/components/icons/base/Menu';
import MoreIcon from 'grommet/components/icons/base/More';

import { toggleNavBar, toggleSideBar } from 'views/actions';

import { selectNavbarVisible, selectSidebarVisible, selectSmallScreen } from 'views/selectors';

const SidebarView = (props) => {
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
               <Header size="large" justify="between" pad={ { horizontal: 'medium' } }>
                  {toggleNavButton}
                  <Title truncate={false}>{props.title}</Title>
                  {toggleSideButton}
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
   title: PropTypes.string.isRequired,
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

import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Header from 'grommet/components/Header';
import Title from 'grommet/components/Title';

import MenuIcon from 'grommet/components/icons/base/Menu';

import { toggleNavBar } from 'views/actions';

import { selectNavbarVisible } from 'views/selectors';

const SimpleView = (props) => {
   let toggleNavButton;
   if (!props.navbarVisible) {
      toggleNavButton = <Button onClick={() => props.onToggleNavBar()} icon={<MenuIcon/>} />;
   }

   return (
      <Box direction='column'>
         <Box direction='row'>
            <Header size='large' justify='between' margin={ { horizontal: 'medium' } }>
               {toggleNavButton}
               <Title truncate={false}>{props.title}</Title>
            </Header>
         </Box>
         {props.children}
      </Box>
   );
};

SimpleView.propTypes = {
   navbarVisible: PropTypes.bool.isRequired,
   onToggleNavBar: PropTypes.func.isRequired,
   title: PropTypes.string.isRequired,
   children: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      navbarVisible: selectNavbarVisible(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      onToggleNavBar: bindActionCreators(toggleNavBar, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SimpleView);

import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Header from 'grommet/components/Header';
import Heading from 'grommet/components/Heading';
import Title from 'grommet/components/Title';

import MenuIcon from 'grommet/components/icons/base/Menu';

import { toggleNavBar } from 'views/actions';

import { selectNavbarVisible } from 'views/selectors';

const SimpleView = (props) => {
   const heading = 'title';

   let toggleNavButton;
   if (!props.navbarVisible) {
      toggleNavButton = <Button onClick={() => props.onToggleNavBar()} icon={<MenuIcon/>} />;
   }

   return (
      <Box direction='column'>
         <Box direction='row'>
            <Header>
               <Title size="large" justify="between" responsive={false}>
                  {toggleNavButton}
                  <Heading>{heading}</Heading>
               </Title>
            </Header>
         </Box>
         {props.children}
      </Box>
   );
};

SimpleView.propTypes = {
   navbarVisible: PropTypes.bool.isRequired,
   onToggleNavBar: PropTypes.func.isRequired,
   children: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
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

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SimpleView));

import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Menu from 'grommet/components/Menu';
import Sidebar from 'grommet/components/Sidebar';

import CloseIcon from 'grommet/components/icons/base/Close';

import { hideSideBarOnSmallScreen } from 'views/actions';

import { selectSidebarVisible, selectSmallScreen } from 'views/selectors';

class ButtonsSidebar extends Component {

   _renderButton(option, index, onClose) {
      return <Button key={index} align='start' plain={true} label={option.label}
         onClick={() => { option.action(); onClose(); } } icon={ option.icon } />;
   }

   render() {
      let closeButton;
      if (this.props.smallScreen) {
         closeButton = <Button align='start' onClick={() => this.props.onClose()} icon={<CloseIcon/>} />;
      }

      return (
         <Sidebar size='small' colorIndex='light-3'>
            <Box margin='medium'>
               <Menu>
                  { closeButton }
                  { this.props.options.map((option, i) => this._renderButton(option, i, this.props.onClose)) }
               </Menu>
            </Box>
         </Sidebar>
      );
   }
}

ButtonsSidebar.propTypes = {
   sidebarVisible: PropTypes.bool.isRequired,
   smallScreen: PropTypes.bool.isRequired,
   onClose: PropTypes.func,
   options: PropTypes.arrayOf(PropTypes.shape({
      label: PropTypes.string,
      action: PropTypes.func
   }))
};

const mapStateToProps = (state) => {
   return {
      sidebarVisible: selectSidebarVisible(state),
      smallScreen: selectSmallScreen(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      onClose: bindActionCreators(hideSideBarOnSmallScreen, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(ButtonsSidebar);

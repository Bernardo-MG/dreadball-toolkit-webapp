import React from 'react';

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

const ButtonsSidebar = (props) => {
   let closeButton;
   if (props.smallScreen) {
      closeButton = <Button align="start" onClick={() => props.onClose()} icon={<CloseIcon/>} />;
   }

   return (
      <Sidebar size="small" colorIndex="light-3">
         <Box pad="medium">
            <Menu>
               { closeButton }
               { props.options.map((option, i) =>
                  <Button key={i} align="start" plain={true} label={option.label} onClick={option.action} />
               )}
            </Menu>
         </Box>
      </Sidebar>
   );
};

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

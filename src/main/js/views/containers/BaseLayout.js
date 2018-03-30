import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { injectIntl } from 'react-intl';

import App from 'grommet/components/App';
import Split from 'grommet/components/Split';

import MainSidebar from 'views/containers/MainSidebar';

import titleMessages from 'i18n/title';
import appMessages from 'i18n/app';

import { setSmallScreenStatus } from 'views/actions';

import { selectNavbarVisible, selectSmallScreen } from 'views/selectors';

class BaseLayout extends Component {

   _onResponsiveToggleNav(columns) {
      const small = columns === 'single';

      this.props.onSetSmallScreen(small);
   }

   render() {
      let nav;
      if (this.props.navbarVisible) {
         const links = [];
         links.push({ path: '/dbx', label: this.props.intl.formatMessage(titleMessages.dbxTeamBuilder) });
         links.push({ path: '/players', label: this.props.intl.formatMessage(titleMessages.dbxPlayers) });

         const title = this.props.intl.formatMessage(appMessages.name);

         nav = <MainSidebar title={title} links={links} />;
      }

      const priority = (this.props.navbarVisible && this.props.smallScreen ? 'left' : 'right');
      const toggleResponsive = this._onResponsiveToggleNav.bind(this);

      return (
         <App centered={false}>
            <Split priority={priority} flex="right" separator={true} onResponsive={toggleResponsive}>
               {nav}
               {this.props.children}
            </Split>
         </App>
      );
   }
}

BaseLayout.propTypes = {
   navbarVisible: PropTypes.bool.isRequired,
   smallScreen: PropTypes.bool.isRequired,
   onSetSmallScreen: PropTypes.func.isRequired,
   children: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      navbarVisible: selectNavbarVisible(state),
      smallScreen: selectSmallScreen(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      onSetSmallScreen: bindActionCreators(setSmallScreenStatus, dispatch)
   };
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(BaseLayout));

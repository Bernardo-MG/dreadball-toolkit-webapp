import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import App from 'grommet/components/App';
import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import Split from 'grommet/components/Split';

import CloseIcon from 'grommet/components/icons/base/Close';
import MenuIcon from 'grommet/components/icons/base/Menu';

import MainSidebar from 'components/layout/MainSidebar';

import titleMessages from 'i18n/title';
import appMessages from 'i18n/app';

class BaseLayout extends Component {

   constructor(props) {
      super(props);

      this.state = { navbarVisible: true, smallScreen: false };
   }

   _onHideIfResponsiveNav() {
      const small = this.state.smallScreen;

      this.setState({
         ...this.state,
         navbarVisible: !small
      });
   }

   _onToggleNav() {
      const visible = this.state.navbarVisible;

      this.setState({
         ...this.state,
         navbarVisible: !visible
      });
   }

   _onResponsiveToggleNav(columns) {
      const small = columns === 'single';
      const visible = !small;

      this.setState({
         ...this.state,
         navbarVisible: visible,
         smallScreen: small
      });
   }

   render() {
      const links = [];
      links.push({ path: '/dbx', label: this.props.intl.formatMessage(titleMessages.dbxTeamBuilder) });
      links.push({ path: '/players', label: this.props.intl.formatMessage(titleMessages.dbxPlayers) });

      const toggle = this._onToggleNav.bind(this);
      let headButton;
      if (!this.state.navbarVisible) {
         headButton = <Button onClick={() => toggle()} icon={<MenuIcon/>} />;
      }
      const menuButton = <Button onClick={() => toggle()} icon={<CloseIcon/>} />;

      const title = this.props.intl.formatMessage(appMessages.name);

      let nav;
      const hideNav = this._onHideIfResponsiveNav.bind(this);
      if (this.state.navbarVisible) {
         nav = <MainSidebar title={title} links={links} menuButton={menuButton} onClickLink={hideNav} />;
      }

      const toggleResponsive = this._onResponsiveToggleNav.bind(this);

      const priority = (this.state.navbarVisible && this.state.smallScreen ? 'left' : 'right');

      return (
         <App centered={false}>
            <Split priority={priority} flex="right" separator={true} onResponsive={toggleResponsive}>
               {nav}
               <Box direction='column'>
                  {headButton}
                  {this.props.children}
               </Box>
            </Split>
         </App>
      );
   }
}

BaseLayout.propTypes = {
   children: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(BaseLayout);

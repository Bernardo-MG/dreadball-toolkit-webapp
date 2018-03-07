import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import App from 'grommet/components/App';
import Split from 'grommet/components/Split';

import MainSidebar from 'components/layout/MainSidebar';

import titleMessages from 'i18n/title';
import appMessages from 'i18n/app';

class BaseLayout extends Component {
   render() {
      const links = [];
      links.push({ path: '/dbx', label: this.props.intl.formatMessage(titleMessages.dbxTeamBuilder) });
      links.push({ path: '/players', label: this.props.intl.formatMessage(titleMessages.dbxPlayers) });

      const title = this.props.intl.formatMessage(appMessages.name);

      return (
         <App centered={false}>
            <Split flex="right" separator={true} >
               <MainSidebar title={title} links={links} />
               {this.props.children}
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

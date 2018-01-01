import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Anchor from 'grommet/components/Anchor';
import Header from 'grommet/components/Header';
import Menu from 'grommet/components/Menu';
import Sidebar from 'grommet/components/Sidebar';
import Footer from 'grommet/components/Footer';

import SocialGithubIcon from 'grommet/components/icons/base/SocialGithub';

import titleMessages from 'i18n/title';

const AppHeader = (props) =>
   <Sidebar size="medium" colorIndex="light-2">
      <Header size="large" justify="between" pad={ { horizontal: 'medium' } }>
         <p>APP_NAME</p>
      </Header>
      <Menu fill={true} primary={true}>
         <Anchor path='/dbx' label={props.intl.formatMessage(titleMessages.dbxTeamBuilder)} />
         <Anchor path='/players' label={props.intl.formatMessage(titleMessages.dbxPlayers)} />
      </Menu>
      <Footer pad={ { horizontal: 'medium', vertical: 'small' } }>
         <p>{APP_VERSION}</p> <a href={REPO_URL}><SocialGithubIcon /></a>
      </Footer>
   </Sidebar>;

AppHeader.propTypes = {
   intl: PropTypes.object.isRequired
};

export default injectIntl(AppHeader);

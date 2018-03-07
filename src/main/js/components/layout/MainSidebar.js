import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Anchor from 'grommet/components/Anchor';
import Button from 'grommet/components/Button';
import Header from 'grommet/components/Header';
import Menu from 'grommet/components/Menu';
import Sidebar from 'grommet/components/Sidebar';
import Footer from 'grommet/components/Footer';

import SocialGithubIcon from 'grommet/components/icons/base/SocialGithub';

import titleMessages from 'i18n/title';
import appMessages from 'i18n/app';

const MainSidebar = (props) =>
   <Sidebar size="small" colorIndex="light-2">
      <Header size="large" justify="between" pad={ { horizontal: 'medium' } }>
         {props.intl.formatMessage(appMessages.name)}
      </Header>
      <Menu fill={true} primary={true}>
         <Anchor path='/dbx' label={props.intl.formatMessage(titleMessages.dbxTeamBuilder)} />
         <Anchor path='/players' label={props.intl.formatMessage(titleMessages.dbxPlayers)} />
      </Menu>
      <Footer pad={ { horizontal: 'medium', vertical: 'small' } }>
         <p>{APP_VERSION}</p> <Button href={REPO_URL} icon={<SocialGithubIcon/>} />
      </Footer>
   </Sidebar>;

MainSidebar.propTypes = {
   intl: PropTypes.object.isRequired
};

export default injectIntl(MainSidebar);

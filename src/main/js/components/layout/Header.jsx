import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Header from 'grommet/components/Header';
import Menu from 'grommet/components/Menu';

import NavAnchor from 'components/NavAnchor';
import SocialGithubIcon from 'grommet/components/icons/base/SocialGithub';

import titleMessages from 'i18n/title';

const AppHeader = (props) =>
   <Header justify='center' colorIndex='neutral-4' siz='small'>
      <Box size={ { width: { max: 'xxlarge' } } } direction='row'
         responsive={false} justify='start' align='center'
         pad={ { horizontal: 'medium' } } flex='grow'>
         <Menu label='Label' inline={true} direction='row' flex='grow'>
            <NavAnchor path='/dbx'>{props.intl.formatMessage(titleMessages.dbxTeamBuilder)}</NavAnchor>
            <NavAnchor path='/players'>{props.intl.formatMessage(titleMessages.dbxPlayers)}</NavAnchor>
         </Menu>
         <p>{APP_VERSION}</p>
         <a href={REPO_URL}><SocialGithubIcon /></a>
      </Box>
   </Header>;

AppHeader.propTypes = {
   intl: PropTypes.object.isRequired
};

export default injectIntl(AppHeader);

import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Anchor from 'grommet/components/Anchor';
import Box from 'grommet/components/Box';
import Paragraph from 'grommet/components/Paragraph';

import SimpleView from 'views/containers/SimpleView';

import titleMessages from 'i18n/title';

const About = (props) =>
   <SimpleView title={props.intl.formatMessage(titleMessages.about)}>
      <Box justify='center' align='center' margin='medium'>
         <Paragraph>I created this application mostly as a way to learn how to create a React application, mixed with Java and Spring. But also because I wanted to create a tool for a game which I like, even if I no longer play it that much.</Paragraph>
         <Paragraph><Anchor label='Dreadball' href='http://www.manticgames.com/games/dreadball.html'/> and Dreadball Xtreme are tabletop games created by <Anchor label='Mantic' href='http://www.manticgames.com/'/>. This application is unnaffiliated, and created by Bernardo Martínez.</Paragraph>
         <Paragraph>The code is open source and <Anchor label='available at Github' href='https://github.com/Bernardo-MG/dreadball-toolkit-webapp'/>.</Paragraph>
      </Box>
   </SimpleView>;

About.propTypes = {
   intl: PropTypes.object.isRequired
};

export default injectIntl(About);

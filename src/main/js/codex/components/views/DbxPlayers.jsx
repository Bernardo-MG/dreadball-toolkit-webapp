import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';

import NextPageButton from 'containers/NextPageButton';
import PreviousPageButton from 'containers/PreviousPageButton';

import LoadableDbxUnitTable from 'codex/containers/LoadableDbxUnitTable';

import buttonMessages from 'i18n/button';
import titleMessages from 'i18n/title';

const DbxPlayers = (props) =>
   <Box>
      <Heading tag='h1'>{props.intl.formatMessage(titleMessages.dbxPlayers)}</Heading>
      <LoadableDbxUnitTable/>
      <Box direction='row'>
         <Box margin='small'>
            <PreviousPageButton label={props.intl.formatMessage(buttonMessages.previous)} />
         </Box>
         <Box margin='small'>
            <NextPageButton label={props.intl.formatMessage(buttonMessages.next)} />
         </Box>
      </Box>
   </Box>;

DbxPlayers.propTypes = {
   intl: PropTypes.object.isRequired
};


export default injectIntl(DbxPlayers);

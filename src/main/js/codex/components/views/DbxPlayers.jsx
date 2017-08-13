import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';

import NextPageButton from 'containers/NextPageButton';
import PreviousPageButton from 'containers/PreviousPageButton';

import LoadableDbxUnitTable from 'codex/containers/LoadableDbxUnitTable';

import titleMessages from 'i18n/title';

const DbxPlayers = (props) =>
   <Box>
      <Heading tag='h1'>{props.intl.formatMessage(titleMessages.dbxPlayers)}</Heading>
      <LoadableDbxUnitTable/>
      <Box direction='row'>
         <Box margin='small'>
            <PreviousPageButton />
         </Box>
         <Box margin='small'>
            <NextPageButton />
         </Box>
      </Box>
   </Box>;

DbxPlayers.propTypes = {
   intl: PropTypes.object.isRequired
};


export default injectIntl(DbxPlayers);

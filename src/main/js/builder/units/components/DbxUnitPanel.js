import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';

import AddUnitButton from 'builder/units/containers/buttons/AddUnitButton';
import UnitPanel from 'codex/components/UnitPanel';

import unitNameMessages from 'i18n/unitName';

const DbxUnitPanel = (props) =>
   <Box>
      <Box direction='row'>
         <AddUnitButton unit={props.source.templateName} />
         <Heading tag='h1'>{props.intl.formatMessage(unitNameMessages[props.source.name])}</Heading>
      </Box>
      <UnitPanel source={props.source} />
   </Box>;

DbxUnitPanel.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(DbxUnitPanel);

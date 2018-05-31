import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Columns from 'grommet/components/Columns';
import Value from 'grommet/components/Value';

import playerMessages from 'i18n/player';

/**
 * Panel showing a player attributes.
 */
const PlayerAttributes = (props) =>
   <Columns size='small'>
      <Box margin='small'>
         <Value value={props.source.movement} label={props.intl.formatMessage(playerMessages.move)} size='small' />
      </Box>
      <Box margin='small'>
         <Value value={props.source.strength} label={props.intl.formatMessage(playerMessages.strength)} size='small' />
      </Box>
      <Box margin='small'>
         <Value value={props.source.speed} label={props.intl.formatMessage(playerMessages.speed)} size='small' />
      </Box>
      <Box margin='small'>
         <Value value={props.source.skill} label={props.intl.formatMessage(playerMessages.skill)} size='small' />
      </Box>
      <Box margin='small'>
         <Value value={props.source.armor} label={props.intl.formatMessage(playerMessages.armor)} size='small' />
      </Box>
   </Columns>;

PlayerAttributes.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(PlayerAttributes);

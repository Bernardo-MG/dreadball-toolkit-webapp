import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Label from 'grommet/components/Label';
import Title from 'grommet/components/Title';

import abilityMessages from 'i18n/ability';
import playerMessages from 'i18n/player';

/**
 * Panel showing a player abilities.
 */
const PlayerAbilities = (props) =>
   <Box full='horizontal' separator='top'>
      <Box justify='center' align='center'>
         <Title>{props.intl.formatMessage(playerMessages.abilities)}</Title>
      </Box>
      <Box direction='row' justify='center' align='center'>
         {props.source.abilities.map((a, i) =>
            <Box key={i} margin='small'><Label key={i} margin='medium'>{props.intl.formatMessage(abilityMessages[a])}</Label></Box>)}
      </Box>
   </Box>;

PlayerAbilities.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(PlayerAbilities);

import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Label from 'grommet/components/Label';
import Title from 'grommet/components/Title';

import playerMessages from 'i18n/player';
import affinityMessages from 'i18n/affinity';

/**
 * Panel showing a player affinities.
 */
const PlayerAffinities = (props) => {
   let affinities;

   if ((props.source.affinityGroups) && (props.source.affinityGroups.length > 0)) {
      affinities =
         <Box full='horizontal' separator='top'>
            <Box justify='center' align='center'>
               <Title>{props.intl.formatMessage(playerMessages.affinities)}</Title>
            </Box>
            <Box direction='row' justify='center' align='center'>
               {props.source.affinityGroups.map((a, i) =>
                  <Box key={i} margin='small'><Label key={i} margin='medium'>{props.intl.formatMessage(affinityMessages[a])}</Label></Box>)}
            </Box>
         </Box>;
   } else {
      affinities = null;
   }

   return affinities;
};

PlayerAffinities.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(PlayerAffinities);

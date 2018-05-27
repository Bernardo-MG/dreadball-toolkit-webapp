import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Columns from 'grommet/components/Columns';
import Value from 'grommet/components/Value';

import playerMessages from 'i18n/player';

/**
 * Panel showing the costs for a player.
 * 
 * It adapts to the data available, as there are several possible configurations for players.
 */
const PlayerCosts = (props) => {
   let friendCost;
   let allyCost;
   let strangerCost;
   let cost;

   // Costs.
   // Affinity players have three costs: stranger, friend and ally.
   // By default players have a single cost value, but in some cases it may not exist.
   if (props.source.strangerCost) {
      strangerCost =
         <Box margin='small'>
            <Value value={props.source.strangerCost} label={props.intl.formatMessage(playerMessages.stranger_cost)} size='small' />
         </Box>;
   } else {
      strangerCost = null;
   }
   if (props.source.friendCost) {
      friendCost =
         <Box margin='small'>
            <Value value={props.source.friendCost} label={props.intl.formatMessage(playerMessages.friend_cost)} size='small' />
         </Box>;
   } else {
      friendCost = null;
   }
   if (props.source.allyCost) {
      allyCost =
         <Box margin='small'>
            <Value value={props.source.allyCost} label={props.intl.formatMessage(playerMessages.ally_cost)} size='small' />
         </Box>;
   } else {
      allyCost = null;
   }
   if (props.source.cost) {
      cost =
         <Box margin='small'>
            <Value value={props.source.cost} label={props.intl.formatMessage(playerMessages.cost)} size='small' />
         </Box>;
   } else {
      cost = null;
   }

   return <Columns size='small'>{friendCost} {allyCost} {strangerCost} {cost}</Columns>;
};

PlayerCosts.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(PlayerCosts);

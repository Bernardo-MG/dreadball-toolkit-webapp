import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Columns from 'grommet/components/Columns';
import Heading from 'grommet/components/Heading';
import Value from 'grommet/components/Value';

import abilityMessages from 'i18n/ability';
import playerMessages from 'i18n/player';
import playerNameMessages from 'i18n/playerName';
import playerRoleMessages from 'i18n/role';

class PlayerPanel extends Component {

   render() {
      let friendCost;
      let allyCost;
      let strangerCost;
      let cost;

      if (this.props.source.friendCost) {
         friendCost =
            <Box pad='small'>
               <Value value={this.props.source.friendCost} label={this.props.intl.formatMessage(playerMessages.friend_cost)} size='small' />
            </Box>;
      } else {
         friendCost = null;
      }
      if (this.props.source.allyCost) {
         allyCost =
            <Box pad='small'>
               <Value value={this.props.source.allyCost} label={this.props.intl.formatMessage(playerMessages.ally_cost)} size='small' />
            </Box>;
      } else {
         allyCost = null;
      }
      if (this.props.source.strangerCost) {
         strangerCost =
            <Box pad='small'>
               <Value value={this.props.source.strangerCost} label={this.props.intl.formatMessage(playerMessages.stranger_cost)} size='small' />
            </Box>;
      } else {
         strangerCost = null;
      }
      if (this.props.source.cost) {
         cost =
            <Box pad='small'>
               <Value value={this.props.source.cost} label={this.props.intl.formatMessage(playerMessages.cost)} size='small' />
            </Box>;
      } else {
         cost = null;
      }

      const costs =
         <Columns size='small'>
            {friendCost}
            {allyCost}
            {strangerCost}
            {cost}
         </Columns>;

      return (
         <Box>
            <Heading tag='h1'>{this.props.intl.formatMessage(playerNameMessages[this.props.source.name])}</Heading>
            <Box>{this.props.intl.formatMessage(playerMessages.role)}: {this.props.intl.formatMessage(playerRoleMessages[this.props.source.role])}</Box>
            <Box>{this.props.intl.formatMessage(playerMessages.abilities)}: {this.props.source.abilities.map((a) => this.props.intl.formatMessage(abilityMessages[a])).join(', ')}</Box>
            <Box>
               <Columns size='small'>
                  <Box pad='small'>
                     <Value value={this.props.source.movement} label={this.props.intl.formatMessage(playerMessages.move)} size='small' />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.strength} label={this.props.intl.formatMessage(playerMessages.strength)} size='small' />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.speed} label={this.props.intl.formatMessage(playerMessages.speed)} size='small' />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.skill} label={this.props.intl.formatMessage(playerMessages.skill)} size='small' />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.armor} label={this.props.intl.formatMessage(playerMessages.armor)} size='small' />
                  </Box>
               </Columns>
            </Box>
            {costs}
         </Box>
      );
   }
}

PlayerPanel.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(PlayerPanel);

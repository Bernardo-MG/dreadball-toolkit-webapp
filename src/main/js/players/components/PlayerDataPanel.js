import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Columns from 'grommet/components/Columns';
import Heading from 'grommet/components/Heading';
import Label from 'grommet/components/Label';
import Title from 'grommet/components/Title';
import Value from 'grommet/components/Value';

import abilityMessages from 'i18n/ability';
import affinityMessages from 'i18n/affinity';
import playerMessages from 'i18n/player';
import playerNameMessages from 'i18n/playerName';
import playerRoleMessages from 'i18n/role';

/**
 * Panel showing all the data for a player.
 * 
 * It adapts to the data available, as there are several possible configurations for players.
 */
class PlayerDataPanel extends Component {

   render() {
      let friendCost;
      let allyCost;
      let strangerCost;
      let cost;

      // Costs.
      // Affinity players have three costs: stranger, friend and ally.
      // By default players have a single cost value, but in some cases it may not exist.
      if (this.props.source.strangerCost) {
         strangerCost =
            <Box margin='small'>
               <Value value={this.props.source.strangerCost} label={this.props.intl.formatMessage(playerMessages.stranger_cost)} size='small' />
            </Box>;
      } else {
         strangerCost = null;
      }
      if (this.props.source.friendCost) {
         friendCost =
            <Box margin='small'>
               <Value value={this.props.source.friendCost} label={this.props.intl.formatMessage(playerMessages.friend_cost)} size='small' />
            </Box>;
      } else {
         friendCost = null;
      }
      if (this.props.source.allyCost) {
         allyCost =
            <Box margin='small'>
               <Value value={this.props.source.allyCost} label={this.props.intl.formatMessage(playerMessages.ally_cost)} size='small' />
            </Box>;
      } else {
         allyCost = null;
      }
      if (this.props.source.cost) {
         cost =
            <Box margin='small'>
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

      // Attributes
      const attributes =
         <Columns size='small'>
            <Box margin='small'>
               <Value value={this.props.source.movement} label={this.props.intl.formatMessage(playerMessages.move)} size='small' />
            </Box>
            <Box margin='small'>
               <Value value={this.props.source.strength} label={this.props.intl.formatMessage(playerMessages.strength)} size='small' />
            </Box>
            <Box margin='small'>
               <Value value={this.props.source.speed} label={this.props.intl.formatMessage(playerMessages.speed)} size='small' />
            </Box>
            <Box margin='small'>
               <Value value={this.props.source.skill} label={this.props.intl.formatMessage(playerMessages.skill)} size='small' />
            </Box>
            <Box margin='small'>
               <Value value={this.props.source.armor} label={this.props.intl.formatMessage(playerMessages.armor)} size='small' />
            </Box>
         </Columns>;

      // Abilities
      const abilities =
         <Box full='horizontal' separator='top'>
            <Box justify='center' align='center'>
               <Title>{this.props.intl.formatMessage(playerMessages.abilities)}</Title>
            </Box>
            <Box direction='row' justify='center' align='center'>
               {this.props.source.abilities.map((a, i) =>
                  <Box key={i} margin='small'><Label key={i} margin='medium'>{this.props.intl.formatMessage(abilityMessages[a])}</Label></Box>)}
            </Box>
         </Box>;

      // Affinities
      let affinities;
      if ((this.props.source.affinityGroups) && (this.props.source.affinityGroups.length > 0)) {
         affinities =
            <Box full='horizontal' separator='top'>
               <Box justify='center' align='center'>
                  <Title>{this.props.intl.formatMessage(playerMessages.affinities)}</Title>
               </Box>
               <Box direction='row' justify='center' align='center'>
                  {this.props.source.affinityGroups.map((a, i) =>
                     <Box key={i} margin='small'><Label key={i} margin='medium'>{this.props.intl.formatMessage(affinityMessages[a])}</Label></Box>)}
               </Box>
            </Box>;
      } else {
         affinities = null;
      }

      // Hated affinities
      let hated;
      if ((this.props.source.hatedAffinityGroups) && (this.props.source.hatedAffinityGroups.length > 0)) {
         hated =
            <Box full='horizontal' separator='top'>
               <Box justify='center' align='center'>
                  <Title>{this.props.intl.formatMessage(playerMessages.hated_affinities)}</Title>
               </Box>
               <Box direction='row' justify='center' align='center'>
                  {this.props.source.hatedAffinityGroups.map((a, i) =>
                     <Box key={i} margin='small'><Label key={i} margin='medium'>{this.props.intl.formatMessage(affinityMessages[a])}</Label></Box>)}
               </Box>
            </Box>;
      } else {
         hated = null;
      }

      return (
         <Box>
            <Heading tag='h1'>{this.props.intl.formatMessage(playerNameMessages[this.props.source.name])}</Heading>
            <Label align='center'>{this.props.intl.formatMessage(playerRoleMessages[this.props.source.role])}</Label>
            {abilities}
            {affinities}
            {hated}
            <Box separator='horizontal'>{attributes}</Box>
            <Box>{costs}</Box>
         </Box>
      );
   }
}

PlayerDataPanel.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(PlayerDataPanel);

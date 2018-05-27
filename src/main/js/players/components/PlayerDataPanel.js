import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Label from 'grommet/components/Label';

import PlayerAbilities from 'players/components/PlayerAbilities';
import PlayerAffinities from 'players/components/PlayerAffinities';
import PlayerAttributes from 'players/components/PlayerAttributes';
import PlayerCosts from 'players/components/PlayerCosts';
import PlayerHatedAffinities from 'players/components/PlayerHatedAffinities';

import playerNameMessages from 'i18n/playerName';
import playerRoleMessages from 'i18n/role';

/**
 * Panel showing all the data for a player.
 * 
 * It adapts to the data available, as there are several possible configurations for players.
 */
class PlayerDataPanel extends Component {

   render() {
      const costs = <PlayerCosts source={this.props.source} />;
      const attributes = <PlayerAttributes source={this.props.source} />;
      const abilities = <PlayerAbilities source={this.props.source} />;
      const affinities = <PlayerAffinities source={this.props.source} />;
      const hated = <PlayerHatedAffinities source={this.props.source} />;

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

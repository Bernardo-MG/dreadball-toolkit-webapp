import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Article from 'grommet/components/Article';
import Box from 'grommet/components/Box';
import Button from 'grommet/components/Button';
import CircleInformationIcon from 'grommet/components/icons/base/CircleInformation';
import Layer from 'grommet/components/Layer';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';
import TableRow from 'grommet/components/TableRow';

import PlayerDataPanel from 'players/components/PlayerDataPanel';

import playerMessages from 'i18n/player';
import playerNameMessages from 'i18n/playerName';

/**
 * Panel showing a set of players and their data.
 * 
 * The data for each player can be shown by clicking on an info button, which will show a modal screen.
 */
class PlayersDataList extends Component {

   constructor(props) {
      super(props);
      this.state = { selection: undefined };
   }

   _onSelect(selection) {
      this.setState({ selection });
   }

   _onDeselect() {
      this.setState({ selection: undefined });
   }

   render() {
      const { selection } = this.state;

      let detailsLayer;
      if (selection) {
         detailsLayer = (
            <Layer closer={true} onClose={::this._onDeselect}>
               <Article size='large'>
                  <PlayerDataPanel source={selection} />
               </Article>
            </Layer>
         );
      } else {
         detailsLayer = undefined;
      }

      const headers = [];
      headers.push(this.props.intl.formatMessage(playerMessages.name));
      headers.push('');

      return (
         <Box>
            {detailsLayer}
            <Table onMore={this.props.onMore}>
               <TableHeader labels={headers} />
               <tbody>
                  { this.props.source.map((player, i) =>
                     <TableRow key={i}>
                        <td>{this.props.intl.formatMessage(playerNameMessages[player.name])}</td>
                        <td><Button onClick={() => ::this._onSelect(player)} icon={<CircleInformationIcon/>} /></td>
                     </TableRow>
                  )}
               </tbody>
            </Table>
         </Box>
      );
   }
}

PlayersDataList.propTypes = {
   source: PropTypes.array.isRequired,
   intl: PropTypes.object.isRequired,
   onMore: PropTypes.func
};

export default injectIntl(PlayersDataList);

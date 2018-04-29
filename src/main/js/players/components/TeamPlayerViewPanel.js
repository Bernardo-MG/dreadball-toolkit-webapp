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

import PlayerPanel from 'players/components/PlayerPanel';

import labelMessages from 'i18n/label';
import playerMessages from 'i18n/player';
import playerNameMessages from 'i18n/playerName';
import playerRoleMessages from 'i18n/role';

class TeamPlayerViewPanel extends Component {

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

      const select = this._onSelect.bind(this);
      const deselect = this._onDeselect.bind(this);

      if (selection) {
         detailsLayer = (
            <Layer closer={true} onClose={deselect}>
               <Article size='large'>
                  <PlayerPanel source={selection} />
               </Article>
            </Layer>
         );
      } else {
         detailsLayer = undefined;
      }

      const headers = [];
      headers.push('');
      headers.push(this.props.intl.formatMessage(playerMessages.name));
      headers.push(this.props.intl.formatMessage(playerMessages.role));
      headers.push(this.props.intl.formatMessage(playerMessages.cost));
      headers.push(this.props.intl.formatMessage(labelMessages.info));

      return (
         <Box>
            {detailsLayer}
            <Table onMore={this.props.onMore}>
               <TableHeader labels={headers} />
               <tbody>
                  { this.props.source.map((player, i) =>
                     <TableRow key={i}>
                        <td><Button onClick={() => this.props.buttonAction(player.templateName)} icon={this.props.buttonIcon} /></td>
                        <td>{this.props.intl.formatMessage(playerNameMessages[player.name])}</td>
                        <td>{this.props.intl.formatMessage(playerRoleMessages[player.role])}</td>
                        <td>{player.cost}</td>
                        <td><Button onClick={() => select(player)} icon={<CircleInformationIcon/>} /></td>
                     </TableRow>
                  )}
               </tbody>
            </Table>
         </Box>
      );
   }
}

TeamPlayerViewPanel.propTypes = {
   source: PropTypes.array.isRequired,
   onMore: PropTypes.func,
   buttonAction: PropTypes.func.isRequired,
   buttonIcon: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(TeamPlayerViewPanel);

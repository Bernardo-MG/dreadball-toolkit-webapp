import React, { Component, Fragment } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Article from 'grommet/components/Article';
import Button from 'grommet/components/Button';
import CircleInformationIcon from 'grommet/components/icons/base/CircleInformation';
import Layer from 'grommet/components/Layer';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';
import TableRow from 'grommet/components/TableRow';

import PlayerDataPanel from 'players/components/PlayerDataPanel';

import playerMessages from 'i18n/player';
import playerNameMessages from 'i18n/playerName';

class RatedPlayersDataSmallList extends Component {

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

      const select = this._onSelect.bind(this);
      const deselect = this._onDeselect.bind(this);

      let detailsLayer;
      if (selection) {
         detailsLayer = (
            <Layer closer={true} onClose={deselect}>
               <Article size='large'>
                  <PlayerDataPanel source={selection} />
               </Article>
            </Layer>
         );
      } else {
         detailsLayer = undefined;
      }

      const headers = [];
      headers.push('');
      headers.push(this.props.intl.formatMessage(playerMessages.name));
      headers.push('');

      return (
         <Fragment>
            {detailsLayer}
            <Table onMore={this.props.onMore}>
               <TableHeader labels={headers} />
               <tbody>
                  { this.props.source.map((player, i) =>
                     <TableRow key={i}>
                        <td><Button onClick={() => this.props.buttonAction(player.templateName)} icon={this.props.buttonIcon} /></td>
                        <td>{this.props.intl.formatMessage(playerNameMessages[player.name])}</td>
                        <td><Button onClick={() => select(player)} icon={<CircleInformationIcon/>} /></td>
                     </TableRow>
                  )}
               </tbody>
            </Table>
         </Fragment>
      );
   }
}

RatedPlayersDataSmallList.propTypes = {
   source: PropTypes.array.isRequired,
   onMore: PropTypes.func,
   buttonAction: PropTypes.func.isRequired,
   buttonIcon: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(RatedPlayersDataSmallList);

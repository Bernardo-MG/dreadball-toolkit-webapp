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

import UnitPanel from 'codex/components/UnitPanel';

import unitNameMessages from 'i18n/unitName';
import unitRoleMessages from 'i18n/role';

class UnitsViewPanel extends Component {

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
                  <UnitPanel source={selection} />
               </Article>
            </Layer>
         );
      } else {
         detailsLayer = undefined;
      }

      return (
         <Box pad='medium' full={true}>
            {detailsLayer}
            <Table onMore={this.props.onMore}>
               <TableHeader labels={['player', 'role', 'info']} />
               <tbody>
                  { this.props.source.map((unit, i) =>
                     <TableRow key={i}>
                        <td>{this.props.intl.formatMessage(unitNameMessages[unit.name])}</td>
                        <td>{this.props.intl.formatMessage(unitRoleMessages[unit.role])}</td>
                        <td><Button onClick={() => select(unit)} icon={<CircleInformationIcon/>} /></td>
                     </TableRow>
                  )}
               </tbody>
            </Table>
         </Box>
      );
   }
}

UnitsViewPanel.propTypes = {
   source: PropTypes.array.isRequired,
   onMore: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(UnitsViewPanel);

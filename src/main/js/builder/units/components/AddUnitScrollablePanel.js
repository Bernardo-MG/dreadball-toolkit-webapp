import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Article from 'grommet/components/Article';
import Box from 'grommet/components/Box';
import Layer from 'grommet/components/Layer';
import Table from 'grommet/components/Table';
import TableRow from 'grommet/components/TableRow';

import DbxUnitPanel from 'builder/units/components/DbxUnitPanel';

import unitNameMessages from 'i18n/unitName';
import unitRoleMessages from 'i18n/role';

class AddUnitScrollablePanel extends Component {

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
                  <DbxUnitPanel source={selection} />
               </Article>
            </Layer>
         );
      } else {
         detailsLayer = undefined;
      }

      return (
         <Box>
            {detailsLayer}
            <Table selectable={true} onMore={this.props.onMore}>
               <tbody>
                  { this.props.source.map((unit, i) =>
                     <TableRow onClick={() => select(unit)} key={i}>
                        <td>{this.props.intl.formatMessage(unitNameMessages[unit.name])}</td>
                        <td>{this.props.intl.formatMessage(unitRoleMessages[unit.role])}</td>
                        <td>{unit.cost}</td>
                     </TableRow>
                  )}
               </tbody>
            </Table>
         </Box>
      );
   }
}

AddUnitScrollablePanel.propTypes = {
   source: PropTypes.array.isRequired,
   onMore: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(AddUnitScrollablePanel);

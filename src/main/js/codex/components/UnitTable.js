import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Table from 'grommet/components/Table';
import TableRow from 'grommet/components/TableRow';

import unitNameMessages from 'i18n/unitName';

const UnitTable = (props) =>
   <Table onMore={props.onMore}>
      <tbody>
         { props.source.map((unit, i) =>
            <TableRow key={i}>
               <td>{props.intl.formatMessage(unitNameMessages[unit.name])}</td>
            </TableRow>
         )}
      </tbody>
   </Table>;

UnitTable.propTypes = {
   source: PropTypes.array.isRequired,
   onMore: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(UnitTable);

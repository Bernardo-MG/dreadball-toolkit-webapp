import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Table from 'grommet/components/Table';
import TableRow from 'grommet/components/TableRow';

import SortableTableHeader from 'components/SortableTableHeader';

import unitMessages from 'i18n/unit';

const DbxUnitTable = (props) =>
   <Table>
      <SortableTableHeader sortIndex={0} sortAscending={true} onSort={props.onSort} labels={[
         props.intl.formatMessage(unitMessages.name),
         props.intl.formatMessage(unitMessages.role),
         props.intl.formatMessage(unitMessages.move),
         props.intl.formatMessage(unitMessages.strength),
         props.intl.formatMessage(unitMessages.speed),
         props.intl.formatMessage(unitMessages.skill),
         props.intl.formatMessage(unitMessages.armor),
         props.intl.formatMessage(unitMessages.abilities),
         props.intl.formatMessage(unitMessages.stranger_cost),
         props.intl.formatMessage(unitMessages.ally_cost),
         props.intl.formatMessage(unitMessages.friend_cost)
      ]} />
      <tbody>
         { props.source.map((object, i) =>
            <TableRow key={i}>
               <td>{object.name}</td>
               <td>{object.role}</td>
               <td>{object.movement}</td>
               <td>{object.strength}</td>
               <td>{object.speed}</td>
               <td>{object.skill}</td>
               <td>{object.armor}</td>
               <td>{object.abilities}</td>
               <td>{object.strangerCost}</td>
               <td>{object.allyCost}</td>
               <td>{object.friendCost}</td>
            </TableRow>
            )}
      </tbody>
   </Table>;

DbxUnitTable.propTypes = {
   intl: PropTypes.object.isRequired,
   source: PropTypes.array.isRequired,
   onSort: PropTypes.func
};

export default injectIntl(DbxUnitTable);

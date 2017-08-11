import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Table from 'grommet/components/Table';
import TableRow from 'grommet/components/TableRow';

import unitMessages from 'i18n/unit';

const DbxUnitTable = (props) =>
   <Table>
      <thead>
         <tr>
            <th>{props.intl.formatMessage(unitMessages.name)}</th>
            <th>{props.intl.formatMessage(unitMessages.role)}</th>
            <th>{props.intl.formatMessage(unitMessages.move)}</th>
            <th>{props.intl.formatMessage(unitMessages.strength)}</th>
            <th>{props.intl.formatMessage(unitMessages.speed)}</th>
            <th>{props.intl.formatMessage(unitMessages.skill)}</th>
            <th>{props.intl.formatMessage(unitMessages.armor)}</th>
            <th>{props.intl.formatMessage(unitMessages.abilities)}</th>
            <th>{props.intl.formatMessage(unitMessages.stranger_cost)}</th>
            <th>{props.intl.formatMessage(unitMessages.ally_cost)}</th>
            <th>{props.intl.formatMessage(unitMessages.friend_cost)}</th>
         </tr>
      </thead>
      <tbody>
         { props.source.map((object, i) =>
            <TableRow key={i}>
               <td>{object.name}</td>
               <td>{object.role}</td>
               <td>{object.move}</td>
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
   source: PropTypes.array.isRequired
};

export default injectIntl(DbxUnitTable);

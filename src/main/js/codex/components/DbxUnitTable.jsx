import React from 'react';
import Table from 'grommet/components/Table';
import TableRow from 'grommet/components/TableRow';
import { injectIntl } from 'react-intl';
import unitMessages from 'i18n/unit';

const DbxUnitTable = (props) => {
   return (
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
            {props.source.map(function(object, i){
               return <TableRow key={i}>
                        <td>{object.name}</td>
                        <td>{object.role}</td>
                        <td>{object.move}</td>
                        <td>{object.strength}</td>
                        <td>{object.speed}</td>
                        <td>{object.skill}</td>
                        <td>{object.armor}</td>
                        <td>{object.abilities}</td>
                        <td>{object.stranger_cost}</td>
                        <td>{object.ally_cost}</td>
                        <td>{object.friend_cost}</td>
                     </TableRow>;
            })}
         </tbody>
      </Table>
   );
}

export default injectIntl(DbxUnitTable);

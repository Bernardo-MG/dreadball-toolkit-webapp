import React from 'react';
import Table from 'grommet/components/Table';
import TableRow from 'grommet/components/TableRow';
import { injectIntl } from 'react-intl';
import unitMessages from 'i18n/unit';
import Button from 'grommet/components/Button';

const AddUnitTable = (props) => {
   return (
      <Table>
         <thead>
            <tr>
               <th>add</th>
               <th>{props.intl.formatMessage(unitMessages.name)}</th>
               <th>{props.intl.formatMessage(unitMessages.role)}</th>
               <th>{props.intl.formatMessage(unitMessages.move)}</th>
               <th>{props.intl.formatMessage(unitMessages.strength)}</th>
               <th>{props.intl.formatMessage(unitMessages.speed)}</th>
               <th>{props.intl.formatMessage(unitMessages.skill)}</th>
               <th>{props.intl.formatMessage(unitMessages.armor)}</th>
               <th>{props.intl.formatMessage(unitMessages.abilities)}</th>
               <th>{props.intl.formatMessage(unitMessages.cost)}</th>
            </tr>
         </thead>
         <tbody>
            {props.source.map(function (object, i) {
               return <TableRow key={i}>
                        <td><Button label='add' /></td>
                        <td>{object.name}</td>
                        <td>{object.role}</td>
                        <td>{object.move}</td>
                        <td>{object.strength}</td>
                        <td>{object.speed}</td>
                        <td>{object.skill}</td>
                        <td>{object.armor}</td>
                        <td>{object.abilities}</td>
                        <td>{object.cost}</td>
                     </TableRow>;
            })}
         </tbody>
      </Table>
   );
};

export default injectIntl(AddUnitTable);

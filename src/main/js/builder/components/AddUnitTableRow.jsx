import React from 'react';
import TableRow from 'grommet/components/TableRow';
import { injectIntl } from 'react-intl';
import Button from 'grommet/components/Button';

const AddUnitTableRow = (props) => {
   return (
      <TableRow key={props.key}>
         <td><Button label='add' /></td>
         <td>{props.source.name}</td>
         <td>{props.source.role}</td>
         <td>{props.source.move}</td>
         <td>{props.source.strength}</td>
         <td>{props.source.speed}</td>
         <td>{props.source.skill}</td>
         <td>{props.source.armor}</td>
         <td>{props.source.abilities}</td>
         <td>{props.source.cost}</td>
      </TableRow>
   );
};

export default AddUnitTableRow;

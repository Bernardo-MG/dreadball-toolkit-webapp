import React from 'react';

import Table from 'grommet/components/Table';

import { injectIntl } from 'react-intl';
import unitMessages from 'i18n/unit';

import AddUnitTableRow from 'builder/components/AddUnitTableRow';

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
               return <AddUnitTableRow key={i} source={object} />;
            })}
         </tbody>
      </Table>
   );
};

export default injectIntl(AddUnitTable);

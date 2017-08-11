import React from 'react';

import PropTypes from 'prop-types';

import Table from 'grommet/components/Table';

import { injectIntl } from 'react-intl';
import unitMessages from 'i18n/unit';

import AddUnitTableRow from 'builder/containers/AddUnitTableRow';

const AddUnitTable = (props) =>
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
         {props.source.map((object, i) => <AddUnitTableRow index={i} source={object} />)}
      </tbody>
   </Table>;

AddUnitTable.propTypes = {
   intl: PropTypes.object.isRequired,
   source: PropTypes.array.isRequired
};

export default injectIntl(AddUnitTable);

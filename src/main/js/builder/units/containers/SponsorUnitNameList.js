import React from 'react';

import PropTypes from 'prop-types';

import Table from 'grommet/components/Table';
import TableRow from 'grommet/components/TableRow';

import RemoveUnitButton from 'builder/units/containers/buttons/RemoveUnitButton';

import { connect } from 'react-redux';

import { selectUnits } from 'builder/units/selectors';

const SponsorUnitNameList = (props) =>
   <Table>
      <tbody>
         { props.sponsorUnits.map((unit, i) =>
            <TableRow key={i}>
               <td><RemoveUnitButton unit={unit} /></td>
               <td>{unit}</td>
            </TableRow>
         )}
      </tbody>
   </Table>;

SponsorUnitNameList.propTypes = {
   sponsorUnits: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      sponsorUnits: selectUnits(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorUnitNameList);

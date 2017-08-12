import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import TableRow from 'grommet/components/TableRow';

import Button from 'grommet/components/Button';

import * as actions from 'builder/actions';

class AddUnitTableRow extends Component {

   unit;
   index;
   validateSponsorTeam;

   sponsor;

   chooseUnit = () => {
      const units = this.sponsor.units.map((unit) => unit.templateName);
      units.push(this.unit);
      this.validateSponsorTeam(this.sponsor.affinities, units,
            this.sponsor.baseRank,
            this.sponsor.cheerleaders, this.sponsor.coachingDice, this.sponsor.mediBots, this.sponsor.specialMoveCards, this.sponsor.nastySurpriseCards, this.sponsor.wagers);
   };

   constructor(props) {
      super(props);

      this.sponsor = props.sponsor;

      this.unit = props.source.templateName;
      this.index = props.index;

      this.validateSponsorTeam = props.actions.validateSponsorTeam;
   }

   render() {
      return (
         <TableRow key={this.index}>
            <td><Button label='add' onClick={this.chooseUnit} /></td>
            <td>{this.props.source.name}</td>
            <td>{this.props.source.role}</td>
            <td>{this.props.source.move}</td>
            <td>{this.props.source.strength}</td>
            <td>{this.props.source.speed}</td>
            <td>{this.props.source.skill}</td>
            <td>{this.props.source.armor}</td>
            <td>{this.props.source.abilities}</td>
            <td>{this.props.source.cost}</td>
         </TableRow>
      );
   }
}

AddUnitTableRow.propTypes = {
   sponsor: PropTypes.object.isRequired,
   source: PropTypes.object.isRequired,
   index: PropTypes.number.isRequired,
   actions: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      sponsor: state.builder.sponsor
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AddUnitTableRow);

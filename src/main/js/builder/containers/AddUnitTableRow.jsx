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

   chooseUnit = () => {
      const units = this.sponsorUnits.map((unit) => unit.templateName);
      units.push(this.unit);
      this.validateSponsorTeam(this.affinities, units,
            this.baseRank,
            this.cheerleaders, this.coachingDice, this.mediBots, this.specialMoveCards, this.nastySurpriseCards, this.wagers);
   };

   constructor(props) {
      super(props);

      this.sponsorUnits = props.sponsorUnits;
      this.baseRank = props.baseRank;
      this.affinities = props.affinities;
      this.cheerleaders = props.cheerleaders;
      this.coachingDice = props.coachingDice;
      this.mediBots = props.mediBots;
      this.specialMoveCards = props.specialMoveCards;
      this.nastySurpriseCards = props.nastySurpriseCards;
      this.wagers = props.wagers;

      this.unit = props.source.templateName;
      this.index = props.index;

      this.validateSponsorTeam = props.actions.validateSponsorTeam;
   }

   componentWillReceiveProps(props) {
      this.sponsorUnits = props.sponsorUnits;
      this.baseRank = props.baseRank;
      this.affinities = props.affinities;
      this.cheerleaders = props.cheerleaders;
      this.coachingDice = props.coachingDice;
      this.mediBots = props.mediBots;
      this.specialMoveCards = props.specialMoveCards;
      this.nastySurpriseCards = props.nastySurpriseCards;
      this.wagers = props.wagers;
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
   sponsorUnits: PropTypes.object.isRequired,
   baseRank: PropTypes.number.isRequired,
   affinities: PropTypes.array.isRequired,
   cheerleaders: PropTypes.number.isRequired,
   coachingDice: PropTypes.number.isRequired,
   mediBots: PropTypes.number.isRequired,
   specialMoveCards: PropTypes.number.isRequired,
   nastySurpriseCards: PropTypes.number.isRequired,
   wagers: PropTypes.number.isRequired,
   source: PropTypes.object.isRequired,
   index: PropTypes.number.isRequired,
   actions: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      sponsorUnits: state.builder.sponsor.units,
      baseRank: state.builder.sponsor.baseRank,
      affinities: state.builder.sponsor.affinities,
      cheerleaders: state.builder.sponsor.cheerleaders,
      coachingDice: state.builder.sponsor.coachingDice,
      mediBots: state.builder.sponsor.mediBots,
      specialMoveCards: state.builder.sponsor.specialMoveCards,
      nastySurpriseCards: state.builder.sponsor.nastySurpriseCards,
      wagers: state.builder.sponsor.wagers
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

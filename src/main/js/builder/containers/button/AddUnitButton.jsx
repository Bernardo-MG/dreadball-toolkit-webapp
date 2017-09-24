import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';

import * as actions from 'builder/actions';

class AddUnitButton extends Component {

   unit;
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

      this.unit = props.unit;

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

      this.unit = props.unit;
   }

   render() {
      return (
         <Button label='add' onClick={this.chooseUnit} />
      );
   }
}

AddUnitButton.propTypes = {
   sponsorUnits: PropTypes.array.isRequired,
   baseRank: PropTypes.number.isRequired,
   affinities: PropTypes.array.isRequired,
   cheerleaders: PropTypes.number.isRequired,
   coachingDice: PropTypes.number.isRequired,
   mediBots: PropTypes.number.isRequired,
   specialMoveCards: PropTypes.number.isRequired,
   nastySurpriseCards: PropTypes.number.isRequired,
   wagers: PropTypes.number.isRequired,
   unit: PropTypes.string.isRequired,
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
)(AddUnitButton);

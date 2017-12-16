import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { validateSponsorTeam } from 'builder/actions';

import BoundNumberInput from 'components/BoundNumberInput';

class SponsorBoundNumberInput extends Component {

   handleChange;
   updateSponsor;
   validate;

   sponsor;

   setValue = (value) => {
      this.handleChange(value);
      this.sponsor = this.updateSponsor(value, this.sponsor);
      const units = this.sponsor.units.map((unit) => unit.templateName);
      this.validate(this.sponsor.affinities, units,
         this.sponsor.baseRank,
         this.sponsor.cheerleaders, this.sponsor.coachingDice, this.sponsor.mediBots, this.sponsor.specialMoveCards, this.sponsor.nastySurpriseCards, this.sponsor.wagers);
   };

   constructor(props) {
      super(props);

      this.sponsor = props.sponsor;

      this.handleChange = props.handleChange;
      this.updateSponsor = props.updateSponsor;
      this.validate = props.action;
   }

   componentWillReceiveProps(props) {
      this.sponsor = props.sponsor;
   }

   render() {
      return (
         <BoundNumberInput {...this.props} handleChange={this.setValue} />
      );
   }
}

SponsorBoundNumberInput.propTypes = {
   handleChange: PropTypes.func.isRequired,
   updateSponsor: PropTypes.func.isRequired,
   action: PropTypes.func.isRequired,
   sponsor: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      sponsor: state.builder.sponsor
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(validateSponsorTeam, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorBoundNumberInput);

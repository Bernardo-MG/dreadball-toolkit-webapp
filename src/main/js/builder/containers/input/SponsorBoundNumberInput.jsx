import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import BoundNumberInput from 'components/BoundNumberInput';

class SponsorBoundNumberInput extends Component {

   handleChange;
   updateSponsor;
   validate;

   sponsor;

   setValue = (value) => {
      this.handleChange(value);
      this.updateSponsor(value, this.sponsor);
      this.validate(this.sponsor.affinities, this.sponsor.units,
            this.sponsor.baseRank,
            this.sponsor.cheerleaders, this.sponsor.coachingDice, this.sponsor.mediBots, this.sponsor.specialMoveCards, this.sponsor.nastySurpriseCards, this.sponsor.wagers);
   };

   constructor(props) {
      super(props);
      
      this.sponsor = props.sponsor;

      this.handleChange = props.handleChange;
      this.updateSponsor = props.updateSponsor;
      this.validate = props.actions.validateSponsorTeam;
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

const mapStateToProps = (state) => {
   return {
      sponsor: state.builder.sponsor
   }
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(Actions, dispatch)
   }
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorBoundNumberInput);

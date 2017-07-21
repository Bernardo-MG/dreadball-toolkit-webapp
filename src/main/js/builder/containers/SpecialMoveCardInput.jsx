import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import SponsorBoundNumberInput from 'builder/containers/SponsorBoundNumberInput';

class SpecialMoveCardInput extends Component {

   onChange;
   validate;

   sponsor;

   setValue = (value) => {
      this.onChange(value);
      this.validate(this.sponsor.affinities,
            this.sponsor.cheerleaders, this.sponsor.coachingDice, this.sponsor.mediBots, value, this.sponsor.nastySurpriseCards, this.sponsor.wagers);
   };

   constructor(props) {
      super(props);
      
      this.sponsor = props.sponsor;

      this.onChange = props.actions.updateSponsorSpecialMoveCard;
      this.validate = props.actions.validateSponsorTeam;
   }

   render() {
      return (
         <SponsorBoundNumberInput {...this.props} handleChange={this.setValue} />
      );
   }
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.specialMoveCards,
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
)(SpecialMoveCardInput);

import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import SponsorBoundNumberInput from 'builder/containers/input/SponsorBoundNumberInput';

const CoachingDiceInput = (props) => {
   return (
      <SponsorBoundNumberInput {...props}
         handleChange={props.actions.updateSponsorCoachingDice}
         updateSponsor={(value, sponsor) => sponsor.coachingDice = value} />
   );
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.coachingDice
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(Actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CoachingDiceInput);

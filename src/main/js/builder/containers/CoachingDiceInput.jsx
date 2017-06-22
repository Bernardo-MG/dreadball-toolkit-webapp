import React from 'react';
import { connect } from 'react-redux';
import BoundNumberInput from 'components/class BoundNumberInput';

const CoachingDiceInput = (props) => {
   return (
      <BoundNumberInput {...this.props} />
   );
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.coachingDice
   }
};

const mapDispatchToProps = (dispatch) => {
   return {}
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CoachingDiceInput);

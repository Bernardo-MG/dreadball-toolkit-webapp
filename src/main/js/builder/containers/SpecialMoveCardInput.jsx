import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import SponsorBoundNumberInput from 'builder/containers/SponsorBoundNumberInput';

const SpecialMoveCardInput = (props) => {
   return (
      <SponsorBoundNumberInput {...props} handleChange={props.actions.updateSponsorSpecialMoveCard} />
   );
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.specialMoveCard
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

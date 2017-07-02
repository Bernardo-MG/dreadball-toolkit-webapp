import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import SponsorRankBoundNumberInput from 'builder/containers/SponsorRankBoundNumberInput';

const SpecialMoveCardInput = (props) => {
   return (
      <SponsorRankBoundNumberInput {...props} handleChange={props.actions.updateSponsorSpecialMoveCard} />
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

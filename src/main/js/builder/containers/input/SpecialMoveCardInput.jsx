import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import SponsorBoundNumberInput from 'builder/containers/input/SponsorBoundNumberInput';

const SpecialMoveCardInput = (props) => {
   return (
      <SponsorBoundNumberInput {...props}
         handleChange={props.actions.updateSponsorSpecialMoveCard}
         updateSponsor={(value, sponsor) => sponsor.specialMoveCards = value} />
   );
};

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.specialMoveCards
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
)(SpecialMoveCardInput);

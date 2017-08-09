import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import SponsorBoundNumberInput from 'builder/containers/input/SponsorBoundNumberInput';

const NastySurpriseCardInput = (props) => {
   return (
      <SponsorBoundNumberInput {...props}
         handleChange={props.actions.updateSponsorNastySurpriseCard}
         updateSponsor={(value, sponsor) => sponsor.nastySurpriseCards = value} />
   );
};

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.nastySurpriseCards
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
)(NastySurpriseCardInput);

import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import SponsorBoundNumberInput from 'builder/containers/SponsorBoundNumberInput';

const MediBotInput = (props) => {
   return (
      <SponsorBoundNumberInput {...props} handleChange={props.actions.updateSponsorMediBot} />
   );
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.mediBot
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
)(MediBotInput);

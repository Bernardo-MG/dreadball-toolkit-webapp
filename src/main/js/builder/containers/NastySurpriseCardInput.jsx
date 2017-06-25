import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import BoundNumberInput from 'components/BoundNumberInput';

const NastySurpriseCardInput = (props) => {
   return (
      <BoundNumberInput {...props} handleChange={props.actions.updateSponsorNastySurpriseCard} />
   );
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.nastySurpriseCard
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
)(NastySurpriseCardInput);

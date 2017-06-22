import React from 'react';
import { connect } from 'react-redux';
import BoundNumberInput from 'components/BoundNumberInput';

const NastySurpriseCardInput = (props) => {
   return (
      <BoundNumberInput {...props} />
   );
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.nastySurpriseCard
   }
};

const mapDispatchToProps = (dispatch) => {
   return {}
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(NastySurpriseCardInput);

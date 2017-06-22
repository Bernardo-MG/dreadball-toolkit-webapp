import React from 'react';
import { connect } from 'react-redux';
import BoundNumberInput from 'components/BoundNumberInput';

const WagerInput = (props) => {
   return (
      <BoundNumberInput {...props} />
   );
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.wager
   }
};

const mapDispatchToProps = (dispatch) => {
   return {}
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(WagerInput);

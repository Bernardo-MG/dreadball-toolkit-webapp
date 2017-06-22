import React from 'react';
import { connect } from 'react-redux';
import BoundNumberInput from 'components/BoundNumberInput';

const CheerleadersInput = (props) => {
   return (
      <BoundNumberInput {...props} />
   );
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.cheerleaders
   }
};

const mapDispatchToProps = (dispatch) => {
   return {}
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CheerleadersInput);

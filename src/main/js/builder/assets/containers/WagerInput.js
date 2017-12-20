import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setWager } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { selectWagers } from 'builder/assets/selectors';

const WagerInput = (props) =>
   <BoundNumberInput {...props}
      handleChange={props.action} />;

WagerInput.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: selectWagers(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(setWager, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(WagerInput);

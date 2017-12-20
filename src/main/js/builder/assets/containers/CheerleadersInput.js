import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setCheerleaders } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { selectCheerleaders } from 'builder/assets/selectors';

const CheerleadersInput = (props) =>
   <BoundNumberInput {...props}
      handleChange={props.action} />;

CheerleadersInput.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: selectCheerleaders(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(setCheerleaders, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CheerleadersInput);

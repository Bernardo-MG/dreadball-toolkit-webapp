import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setCheerleaders } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { selectCheerleaders } from 'builder/assets/selectors';

const CheerleadersInput = (props) =>
   <BoundNumberInput {...props} />;

CheerleadersInput.propTypes = {
   onChange: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: selectCheerleaders(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      onChange: bindActionCreators(setCheerleaders, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CheerleadersInput);

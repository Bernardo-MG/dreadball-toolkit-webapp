import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setMediBot } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { mediBotsSelector } from 'builder/assets/selectors';

const MediBotInput = (props) =>
   <BoundNumberInput {...props}
      handleChange={props.action} />;

MediBotInput.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: mediBotsSelector(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(setMediBot, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(MediBotInput);

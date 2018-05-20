import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setMediBot } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { selectMediBots } from 'builder/assets/selectors';

const MediBotInput = (props) =>
   <BoundNumberInput {...props} />;

MediBotInput.propTypes = {
   onChange: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: selectMediBots(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      onChange: bindActionCreators(setMediBot, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(MediBotInput);

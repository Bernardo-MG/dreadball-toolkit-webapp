import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setCoachingDice } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { coachingDiceSelector } from 'builder/assets/selectors';

const CoachingDiceInput = (props) =>
   <BoundNumberInput {...props}
      handleChange={props.action} />;

CoachingDiceInput.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: coachingDiceSelector(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(setCoachingDice, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CoachingDiceInput);

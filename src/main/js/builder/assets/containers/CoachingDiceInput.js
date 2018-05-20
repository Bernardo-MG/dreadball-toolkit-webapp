import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setCoachingDice } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { selectCoachingDice } from 'builder/assets/selectors';

const CoachingDiceInput = (props) =>
   <BoundNumberInput {...props} />;

CoachingDiceInput.propTypes = {
   onChange: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: selectCoachingDice(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      onChange: bindActionCreators(setCoachingDice, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CoachingDiceInput);

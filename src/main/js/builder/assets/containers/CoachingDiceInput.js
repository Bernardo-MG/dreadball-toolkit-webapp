import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setCoachingDice } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { selectCoachingDice } from 'builder/assets/selectors';

const CoachingDiceInput = (props) =>
   <BoundNumberInput id={props.id} name={props.name} value={props.value} min={props.min} max={props.max} onChange={props.onChange} />;

CoachingDiceInput.propTypes = {
   onChange: PropTypes.func.isRequired,
   id: PropTypes.string,
   name: PropTypes.string,
   min: PropTypes.number,
   max: PropTypes.number,
   value: PropTypes.number
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

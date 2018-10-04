import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setSpecialMoveCard } from 'builder/assets/actions';

import ObservableNumberInput from 'components/ObservableNumberInput';

import { selectSpecialMoveCards } from 'builder/assets/selectors';

const SpecialMoveCardInput = (props) =>
   <ObservableNumberInput id={props.id} name={props.name} value={props.value} min={props.min} max={props.max} onChange={props.onChange} />;

SpecialMoveCardInput.propTypes = {
   onChange: PropTypes.func.isRequired,
   id: PropTypes.string,
   name: PropTypes.string,
   min: PropTypes.number,
   max: PropTypes.number,
   value: PropTypes.number
};

const mapStateToProps = (state) => {
   return {
      value: selectSpecialMoveCards(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      onChange: bindActionCreators(setSpecialMoveCard, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SpecialMoveCardInput);

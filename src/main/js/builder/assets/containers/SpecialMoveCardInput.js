import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setSpecialMoveCard } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { selectSpecialMoveCards } from 'builder/assets/selectors';

const SpecialMoveCardInput = (props) =>
   <BoundNumberInput {...props} />;

SpecialMoveCardInput.propTypes = {
   onChange: PropTypes.func.isRequired
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

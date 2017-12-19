import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setSpecialMoveCard } from 'builder/assets/actions';

import BoundNumberInput from 'components/BoundNumberInput';

import { specialMoveCardsSelector } from 'builder/assets/selectors';

const SpecialMoveCardInput = (props) =>
   <BoundNumberInput {...props}
      handleChange={props.action} />;

SpecialMoveCardInput.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: specialMoveCardsSelector(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(setSpecialMoveCard, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SpecialMoveCardInput);

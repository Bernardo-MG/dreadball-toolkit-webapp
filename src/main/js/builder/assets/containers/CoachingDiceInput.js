import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setCoachingDice } from 'builder/assets/actions';

import SponsorBoundNumberInput from 'builder/assets/containers/SponsorBoundNumberInput';

import { coachingDiceSelector } from 'builder/assets/selectors';

const CoachingDiceInput = (props) =>
   <SponsorBoundNumberInput {...props}
      handleChange={props.action}
      updateSponsor={(value, sponsor) => {
         const result = Object.assign({}, sponsor);
         result.coachingDice = value;
         return result;
      }} />;

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

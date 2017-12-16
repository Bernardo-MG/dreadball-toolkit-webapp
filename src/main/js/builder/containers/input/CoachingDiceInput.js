import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { updateSponsorCoachingDice } from 'builder/actions';

import SponsorBoundNumberInput from 'builder/containers/input/SponsorBoundNumberInput';

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
      value: state.builder.sponsor.coachingDice
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(updateSponsorCoachingDice, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CoachingDiceInput);

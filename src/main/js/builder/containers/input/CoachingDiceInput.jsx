import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import * as Actions from 'builder/actions';

import SponsorBoundNumberInput from 'builder/containers/input/SponsorBoundNumberInput';

const CoachingDiceInput = (props) =>
   <SponsorBoundNumberInput {...props}
      handleChange={props.actions.updateSponsorCoachingDice}
      updateSponsor={(value, sponsor) => {
         const result = Object.assign({}, sponsor);
         result.coachingDice = value;
         return result;
      }} />;

CoachingDiceInput.propTypes = {
   actions: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.coachingDice
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(Actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CoachingDiceInput);

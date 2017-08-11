import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

const SponsorCoachingDiceValue = (props) => <Value value={props.dice} label='coaching_dice' />;

SponsorCoachingDiceValue.propTypes = {
   dice: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      dice: state.builder.sponsor.coachingDice
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorCoachingDiceValue);

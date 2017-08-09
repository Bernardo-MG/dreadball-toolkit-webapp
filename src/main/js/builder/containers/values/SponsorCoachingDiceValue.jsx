import React from 'react';
import { connect } from 'react-redux';
import Value from 'grommet/components/Value';

const SponsorCoachingDiceValue = (props) => {
   return (
      <Value value={props.rank} label='coaching_dice' />
   );
};

const mapStateToProps = (state) => {
   return {
      rank: state.builder.sponsor.coachingDice
   };
};

const mapDispatchToProps = (dispatch) => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorCoachingDiceValue);

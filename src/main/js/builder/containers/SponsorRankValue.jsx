import React from 'react';
import { connect } from 'react-redux';
import Value from 'grommet/components/Value';

const SponsorRankValue = (props) => {
   return (
      <Value value={props.rank + props.initialRank} label='rank' />
   );
};

const mapStateToProps = (state) => {
   return {
      rank: state.builder.sponsor.rank,
      initialRank: state.builder.defaults.initialRank
   }
};

const mapDispatchToProps = (dispatch) => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorRankValue);

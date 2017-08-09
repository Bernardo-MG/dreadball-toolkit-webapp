import React from 'react';
import { connect } from 'react-redux';
import Value from 'grommet/components/Value';

const SponsorRankValue = (props) => {
   return (
      <Value value={props.rank} label='rank' />
   );
};

const mapStateToProps = (state) => {
   return {
      rank: state.builder.sponsor.rank
   };
};

const mapDispatchToProps = (dispatch) => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorRankValue);

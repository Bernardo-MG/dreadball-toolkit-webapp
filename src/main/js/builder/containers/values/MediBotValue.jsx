import React from 'react';
import { connect } from 'react-redux';
import Value from 'grommet/components/Value';

const MediBotValue = (props) => {
   return (
      <Value value={props.rank} label='medibot' />
   );
};

const mapStateToProps = (state) => {
   return {
      rank: state.builder.sponsor.mediBots
   };
};

const mapDispatchToProps = (dispatch) => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(MediBotValue);

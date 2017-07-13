import React from 'react';
import { connect } from 'react-redux';
import Value from 'grommet/components/Value';

const CheerleadersValue = (props) => {
   return (
      <Value value={props.rank} label='cheerleaders' />
   );
};

const mapStateToProps = (state) => {
   return {
      rank: state.builder.sponsor.cheerleaders
   }
};

const mapDispatchToProps = (dispatch) => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CheerleadersValue);

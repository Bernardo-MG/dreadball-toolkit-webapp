import React from 'react';
import { connect } from 'react-redux';
import Value from 'grommet/components/Value';

const SponsorTeamValue = (props) => {
   return (
      <Value value={props.teamValue} label='teamValue' />
   );
};

const mapStateToProps = (state) => {
   return {
      teamValue: state.builder.sponsor.teamValue
   }
};

const mapDispatchToProps = (dispatch) => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamValue);

import React from 'react';
import { connect } from 'react-redux';
import TeamUnitTable from 'builder/components/TeamUnitTable';

const SponsorTeamUnitTable = (props) => {
   return (
      <TeamUnitTable source={props.source}/>
   );
}

const mapStateToProps = state => ({
   source: state.builder.sponsor.units
});

const mapDispatchToProps = dispatch => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamUnitTable);

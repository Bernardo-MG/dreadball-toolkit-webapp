import React from 'react';
import { connect } from 'react-redux';
import TeamUnitTable from 'builder/components/TeamUnitTable';

const SponsorTeamUnitTable = (props) => {
   return (
      <TeamUnitTable source={props.source}/>
   );
};

const mapStateToProps = (state) => {
   return {
      source: state.builder.sponsor.units
   }
};

const mapDispatchToProps = (dispatch) => {
   return {}
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamUnitTable);

import React from 'react';
import { connect } from 'react-redux';
import TeamUnitTable from 'builder/components/TeamUnitTable';
import { unitsSponsor } from 'models/selectors';

const SponsorTeamUnitTable = (props) => {
   return (
      <TeamUnitTable source={props.source}/>
   );
};

const mapStateToProps = (state) => {
   return {
      source: unitsSponsor(state)
   }
};

const mapDispatchToProps = (dispatch) => {
   return {}
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamUnitTable);

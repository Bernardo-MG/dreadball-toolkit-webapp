import React from 'react';
import { connect } from 'react-redux';
import UnitTable from 'builder/components/UnitTable';

const SponsorUnitTable = (props) => {
   return (
      <UnitTable source={props.source}/>
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
)(SponsorUnitTable);

import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import TeamUnitTable from 'builder/components/TeamUnitTable';

import { unitsSponsor } from 'models/selectors';

class SponsorTeamUnitTable extends Component {

   source;

   constructor(props) {
      super(props);

      const positions = props.sponsorUnits.map(unit => unit.position);
      let posUnits = props.units.map((unit, i) => {
         return {
            position: positions[i], ...unit
         };
      });

      this.source = posUnits;
   }

   render() {
      return (
            <TeamUnitTable source={this.source}/>
      );
   }
}

SponsorTeamUnitTable.propTypes = {
   sponsorUnits: PropTypes.array.isRequired,
   units: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      units: unitsSponsor(state),
      sponsorUnits: state.builder.sponsor.units
   };
};

const mapDispatchToProps = (dispatch) => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamUnitTable);

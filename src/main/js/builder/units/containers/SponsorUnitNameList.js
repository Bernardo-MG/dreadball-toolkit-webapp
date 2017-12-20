import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Listing from 'components/Listing';

import RemovableTeamUnit from 'builder/units/components/RemovableTeamUnit';

import { connect } from 'react-redux';

import { selectUnits } from 'builder/units/selectors';

function toComponent(name) {
   return <RemovableTeamUnit unit={name} />;
}

class SponsorUnitNameList extends Component {

   source;

   constructor(props) {
      super(props);

      this.source = props.sponsorUnits.map((name) => toComponent(name));
   }

   componentWillReceiveProps(props) {
      this.source = props.sponsorUnits.map((name) => toComponent(name));
   }

   render() {
      return (
         <Listing source={this.source} />
      );
   }
}

SponsorUnitNameList.propTypes = {
   sponsorUnits: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      sponsorUnits: selectUnits(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorUnitNameList);

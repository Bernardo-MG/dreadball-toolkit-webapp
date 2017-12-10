import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Listing from 'components/Listing';

import { connect } from 'react-redux';


class SponsorUnitNameList extends Component {

   source;

   constructor(props) {
      super(props);

      this.source = props.sponsorUnits.map((unit) => unit.templateName);
   }

   componentWillReceiveProps(props) {
      this.source = props.sponsorUnits.map((unit) => unit.templateName);
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
      sponsorUnits: state.builder.sponsor.units
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorUnitNameList);

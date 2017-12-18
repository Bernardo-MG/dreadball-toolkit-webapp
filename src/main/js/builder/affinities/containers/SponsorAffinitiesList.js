import React from 'react';

import PropTypes from 'prop-types';

import Listing from 'components/Listing';

import { connect } from 'react-redux';

const SponsorAffinitiesList = (props) =>
   <Listing source={props.source} />;

SponsorAffinitiesList.propTypes = {
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: state.builder.sponsor.affinities
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinitiesList);

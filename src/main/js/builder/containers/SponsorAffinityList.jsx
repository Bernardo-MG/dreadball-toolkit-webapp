import React from 'react';

import PropTypes from 'prop-types';

import Listing from 'components/Listing';

import { connect } from 'react-redux';


const SponsorAffinityList = (props) => {
   return (
      <Listing source={props.source} />
   );
};

SponsorAffinityList.propTypes = {
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: state.builder.sponsor.affinities
   };
};

const mapDispatchToProps = (dispatch) => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityList);

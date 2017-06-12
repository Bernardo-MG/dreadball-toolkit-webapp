import React from 'react';
import Listing from 'components/Listing';
import { connect } from 'react-redux';


const SponsorAffinityList = (props) => {
   return (
      <Listing source={props.source} />
   );
};

const mapStateToProps = state => ({
   source: state.builder.sponsor.affinities
});

const mapDispatchToProps = dispatch => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityList);

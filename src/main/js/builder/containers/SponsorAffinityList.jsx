import React from 'react';
import Listing from 'components/Listing';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';


const SponsorAffinityList = (props) => {
   return (
      <Listing source={props.source} />
   );
}

const mapStateToProps = state => ({
   source: state.builder.sponsor.affinities
});

const mapDispatchToProps = dispatch => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityList);

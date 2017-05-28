import React, { Component } from 'react';
import Listing from 'components/Listing';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';


class SponsorAffinityList extends Component {

   render() {
      return (
         <Listing source={this.props.source} />
      );
   }
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

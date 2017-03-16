import React, { Component } from 'react'
import Dropdown from 'react-toolbox/lib/dropdown';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from '../actions/dbxBuilder';

const SponsorAffinitiesLine = (props) => {
   if (props.source) {
      var list;
      
      list = props.source.join(", ");
      return (
         <div>
            {list}
         </div>
      );
   } else {
      return (
         <div/>
      );
   }
};

const mapStateToProps = (state) => ({
   source: state.dbxBuilder.sponsorChosenAffinities
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinitiesLine);
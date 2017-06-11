import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import Value from 'grommet/components/Value';

class SponsorRankValue extends Component {

   render() {
      return (
         <Value value={this.props.rank + this.props.initialRank} label='rank' />
      );
   }
}

const mapStateToProps = state => ({
   rank: state.builder.sponsor.rank,
   initialRank: state.builder.defaults.initialRank
});

const mapDispatchToProps = dispatch => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorRankValue);

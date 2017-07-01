import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import DbxTeamBuilder from 'builder/components/views/DbxTeamBuilder';

class ContainerDbxTeamBuilder extends Component {

   constructor(props) {
      super(props);
      this.props.actions.loadDefaults();
      this.props.actions.beginDbxTeamBuilding();
   }

   render() {
      return (
         <DbxTeamBuilder handleFinishedAffinities={this.props.actions.reloadSponsorRank}/>
      );
   }
}

const mapStateToProps = (state) => ({
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(ContainerDbxTeamBuilder);

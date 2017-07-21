import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import DbxTeamBuilder from 'builder/components/views/DbxTeamBuilder';

class ContainerDbxTeamBuilder extends Component {
   
   props;
   validateSponsorTeam;

   constructor(props) {
      super(props);

      this.props = props;

      this.validateSponsorTeam = props.actions.validateSponsorTeam;

      this.props.actions.beginDbxTeamBuilding();
   }

   onFinishAffinities() {
      this.validateSponsorTeam(this.props.affinities);
   }

   render() {
      return (
         <DbxTeamBuilder handleFinishedAffinities={this.onFinishAffinities.bind(this)}/>
      );
   }
}

const mapStateToProps = (state) => {
   return {
      affinities: state.builder.sponsor.affinities
   }
};

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(ContainerDbxTeamBuilder);

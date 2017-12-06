import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import DbxTeamBuilder from 'builder/components/views/DbxTeamBuilder';

class ContainerDbxTeamBuilder extends Component {

   props;
   validate;

   constructor(props) {
      super(props);

      this.props = props;

      this.validate = props.actions.validateSponsorAffinities;

      this.props.actions.beginDbxTeamBuilding();
   }

   onFinishAffinities() {
      this.validate(this.props.affinities);
   }

   render() {
      return (
         <DbxTeamBuilder handleFinishedAffinities={this.onFinishAffinities.bind(this)}/>
      );
   }
}

ContainerDbxTeamBuilder.propTypes = {
   actions: PropTypes.object.isRequired,
   affinities: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      affinities: state.builder.sponsor.affinities
   };
};


const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(Actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(ContainerDbxTeamBuilder);

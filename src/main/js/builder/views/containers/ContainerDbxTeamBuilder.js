import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { clearTeam, validateSponsorAffinities } from 'builder/actions';
import { fetch as fetchPlayers } from 'models/actions/sponsorPlayer';

import DbxTeamBuilder from 'builder/views/components/DbxTeamBuilder';

class ContainerDbxTeamBuilder extends Component {

   props;
   validate;

   constructor(props) {
      super(props);

      this.props = props;

      this.validate = props.actionValidate;

      this.props.actionBegin();
   }

   onFinishAffinities() {
      this.validate();
   }

   render() {
      return (
         <DbxTeamBuilder onFinishAffinities={this.onFinishAffinities.bind(this)} onLoadPlayers={this.props.loadPlayers}/>
      );
   }
}

ContainerDbxTeamBuilder.propTypes = {
   loadPlayers: PropTypes.func.isRequired,
   actionValidate: PropTypes.func.isRequired,
   actionBegin: PropTypes.func.isRequired
};

const mapStateToProps = () => {
   return {};
};


const mapDispatchToProps = (dispatch) => {
   return {
      loadPlayers: bindActionCreators(fetchPlayers, dispatch),
      actionValidate: bindActionCreators(validateSponsorAffinities, dispatch),
      actionBegin: bindActionCreators(clearTeam, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(ContainerDbxTeamBuilder);

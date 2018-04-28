import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { clearTeam, validateSponsorAffinities } from 'builder/actions';
import { fetch as fetchPlayers } from 'models/actions/affinityPlayers';
import { requestTeamReport } from 'report/actions';

import DbxTeamBuilder from 'builder/views/components/DbxTeamBuilder';

class ContainerDbxTeamBuilder extends Component {

   props;
   validate;

   constructor(props) {
      super(props);

      this.props = props;

      this.validate = props.actionValidate;

      this.props.initialize();
   }

   onFinishAffinities() {
      this.validate();
   }

   render() {
      return (
         <DbxTeamBuilder onFinishAffinities={ this.onFinishAffinities.bind(this) } onLoadPlayers={ this.props.loadPlayers }
            onGenerateTeamReport= { this.props.generateReport }/>
      );
   }
}

ContainerDbxTeamBuilder.propTypes = {
   loadPlayers: PropTypes.func.isRequired,
   actionValidate: PropTypes.func.isRequired,
   initialize: PropTypes.func.isRequired,
   generateReport: PropTypes.func.isRequired
};

const mapStateToProps = () => {
   return {};
};


const mapDispatchToProps = (dispatch) => {
   return {
      generateReport: bindActionCreators(requestTeamReport, dispatch),
      loadPlayers: bindActionCreators(fetchPlayers, dispatch),
      actionValidate: bindActionCreators(validateSponsorAffinities, dispatch),
      initialize: bindActionCreators(clearTeam, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(ContainerDbxTeamBuilder);

import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { clearTeam, validateSponsorAffinities } from 'builder/actions';
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
         <DbxTeamBuilder onFinishAffinities={this.onFinishAffinities.bind(this)}/>
      );
   }
}

ContainerDbxTeamBuilder.propTypes = {
   actionValidate: PropTypes.func.isRequired,
   actionBegin: PropTypes.func.isRequired
};

const mapStateToProps = () => {
   return {};
};


const mapDispatchToProps = (dispatch) => {
   return {
      actionValidate: bindActionCreators(validateSponsorAffinities, dispatch),
      actionBegin: bindActionCreators(clearTeam, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(ContainerDbxTeamBuilder);

import React, { Component } from 'react'
import { connect } from 'react-redux';
import DbxTeamBuilder from 'components/views/builder/DbxTeamBuilder';
import { bindActionCreators } from 'redux';
import * as Actions from 'actions/dbxBuilder';

class ContainerDbxTeamBuilder extends Component {
   
   constructor(props) {
      super(props);
      this.props.actions.beginDbxTeamBuilding();
   }
   
   render() {
      return (
         <DbxTeamBuilder source={this.props.source}/>
      );
   };
};

const mapStateToProps = (state) => ({
   source: state.dbxBuilder
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(ContainerDbxTeamBuilder);
import React, { Component } from 'react'
import { connect } from 'react-redux';
import DbxTeamBuilder from '../../../components/views/builder/DbxTeamBuilder';

const ContainerDbxTeamBuilder = (props) => {
   return (
      <DbxTeamBuilder source={props.source}/>
   );
};

const mapStateToProps = (state) => ({
   source: state.dbxBuilder
});

const mapDispatchToProps = (dispatch) => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(ContainerDbxTeamBuilder);
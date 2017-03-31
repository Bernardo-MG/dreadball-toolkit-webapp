import React, { Component } from 'react'
import TeamBuilderUnitTable from '../components/TeamBuilderUnitTable';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as Actions from '../actions/codex';
import { injectIntl } from 'react-intl';

class LoadableTeamBuilderUnitTable extends Component {

   componentDidMount() {
      this.props.actions.fetchUnits(this.props.intl, this.props.affinities);
   }
   
   render() {
      return (
         <TeamBuilderUnitTable source={this.props.source}/>
      )
   }
}

const mapStateToProps = (state) => ({
   source: state.codex.units,
   affinities: state.dbxBuilder.sponsorChosenAffinities
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(LoadableTeamBuilderUnitTable));

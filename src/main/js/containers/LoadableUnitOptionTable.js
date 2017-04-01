import React, { Component } from 'react'
import UnitOptionTable from '../components/UnitOptionTable';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as Actions from '../actions/codex';
import { injectIntl } from 'react-intl';

class LoadableUnitOptionTable extends Component {

   componentDidMount() {
      this.props.actions.fetchUnits(this.props.intl, this.props.affinities);
   }
   
   render() {
      return (
         <UnitOptionTable source={this.props.source}/>
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
)(LoadableUnitOptionTable));

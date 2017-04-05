import React, { Component } from 'react'
import UnitOptionTable from '../components/UnitOptionTable';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as actions from '../actions/request/unit';
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
   actions: bindActionCreators(actions, dispatch)
});

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(LoadableUnitOptionTable));

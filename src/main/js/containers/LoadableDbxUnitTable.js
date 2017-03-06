import React, { Component } from 'react'
import DbxUnitTable from '../components/DbxUnitTable';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as Actions from '../actions/codex';
import { injectIntl } from 'react-intl';

class LoadableDbxUnitTable extends Component {
   
   componentDidMount() {
      this.props.actions.fetchUnits(this.props.intl);
   }
   
   render() {
      return (
         <DbxUnitTable source={this.props.source}/>
      )
   }
}

const mapStateToProps = (state) => ({
   source: state.codex.units
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
})

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(LoadableDbxUnitTable));

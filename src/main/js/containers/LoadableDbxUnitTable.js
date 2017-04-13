import React, { Component } from 'react'
import DbxUnitTable from 'components/DbxUnitTable';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as actions from 'actions/request/unit';
import { injectIntl } from 'react-intl';
import { players } from 'models/selectors';

class LoadableDbxUnitTable extends Component {
   
   componentDidMount() {
      this.props.actions.fetch(this.props.intl);
   }
   
   render() {
      return (
         <DbxUnitTable source={this.props.source}/>
      )
   }
}

const mapStateToProps = (state) => ({
   source: players(state)
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(actions, dispatch)
});

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(LoadableDbxUnitTable));

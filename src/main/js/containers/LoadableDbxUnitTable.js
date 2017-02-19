import React, { Component } from 'react'
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as Actions from '../actions/codex';
import { loadUnits } from '../actions/codex';
import DbxUnitTable from '../components/DbxUnitTable';

class LoadableDbxUnitTable extends Component {

	componentDidMount() {
		this.props.actions.fetchUnits();
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

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(LoadableDbxUnitTable);

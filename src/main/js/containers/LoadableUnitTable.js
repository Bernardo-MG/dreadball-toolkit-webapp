import React, { Component } from 'react'
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as Actions from '../actions/codex';
import { loadUnits } from '../actions/codex';
import UnitTable from '../components/UnitTable';

class LoadableUnitTable extends Component {

	componentDidMount() {
		const units = [
		  {name: 'Unit', role: 'Jack', cost: 10}
		];
		this.props.actions.loadUnits(units)
	}
	
	render() {
		return (
			<UnitTable source={this.props.source}/>
		)
	}
}

const mapStateToProps = (state) => ({
    source: state.units
});

const mapDispatchToProps = (dispatch) => ({
    actions: bindActionCreators(Actions, dispatch)
})

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(LoadableUnitTable);

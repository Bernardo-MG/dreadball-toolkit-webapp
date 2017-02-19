import React, { Component } from 'react'
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as Actions from '../actions/codex';
import { loadUnits } from '../actions/codex';
import DbxUnitTable from '../components/DbxUnitTable';

class LoadableDbxUnitTable extends Component {

	componentDidMount() {
		fetch('./rest/codex/unit').then(function(response) {
			return response.json()
		})
		const units = [
		  {name: 'Unit', role: 'Jack', move: 1, strength: 2, speed: 3, skill: 4, armour: 5, abilities: 'abilities', groups: 'groups', stranger_cost: 30, ally_cost: 20, friend_cost: 10}
		];
		this.props.actions.loadUnits(units)
	}
	
	render() {
		return (
			<DbxUnitTable source={this.props.source}/>
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
)(LoadableDbxUnitTable);

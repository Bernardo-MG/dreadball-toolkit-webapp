import React from 'react';
import { Table } from 'react-toolbox';
import loadPlayers from '../actions/codex';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as Actions from '../actions/codex';
import UnitTable from '../components/UnitTable';

const mapStateToProps = (state) => ({
    source: state.source
});

const mapDispatchToProps = (dispatch) => ({
    actions: bindActionCreators(Actions, dispatch)
})

let LoadableUnitTable = connect(
    mapStateToProps,
    mapDispatchToProps
)(UnitTable);

export default LoadableUnitTable;
module.exports = LoadableUnitTable;
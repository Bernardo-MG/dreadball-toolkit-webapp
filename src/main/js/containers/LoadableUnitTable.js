import React from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as Actions from '../actions/codex';
import UnitTable from '../components/UnitTable';

const mapStateToProps = (state) => ({
    source: state.players
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
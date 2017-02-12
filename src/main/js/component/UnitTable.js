import React from 'react';
import { Table } from 'react-toolbox';
import loadPlayers from '../actions/codex';
import {bindActionCreators} from 'redux';
import {connect} from 'react-redux';
import * as Actions from '../actions/codex';

const UnitModel = {
  name: {type: String},
  role: {type: String},
  cost: {type: Number}
};

const units = [
  {name: 'Unit', role: 'Jack', cost: 10}
];

class UnitTable extends React.Component {
  state = { source: [] };
  
  componentDidMount() {
    var loadPlayers = loadPlayers;
    //dispatch(loadPlayers(units));
    //loadPlayers.bind(this);
    //fetchPlayers(units);
    //this.setState({ source: units });
  }

  render () {
    return (
      <Table
        model={UnitModel}
        source={this.state.source}
        selectable={false}
        multiSelectable={false}
      />
    );
  }
}

const mapStateToProps = (state) => ({
    state: state
});

const mapDispatchToProps = (dispatch) => ({
    actions: bindActionCreators(Actions, dispatch)
})

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(UnitTable);
module.exports = connect(
    mapStateToProps,
    mapDispatchToProps
)(UnitTable);
import React from 'react';

import { Table } from 'react-toolbox';

import loadPlayers from '../action/codex';

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
    //store.dispatch(loadPlayers(units));
    //loadPlayers.bind(this);
    //fetchPlayers(units);
    this.setState({ source: units });
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

export default UnitTable;
module.exports = UnitTable;
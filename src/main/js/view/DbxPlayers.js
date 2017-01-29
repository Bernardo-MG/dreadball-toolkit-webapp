import React from 'react';

import { Table } from 'react-toolbox';

const UnitModel = {
  name: {type: String},
  role: {type: String},
  cost: {type: Number}
};

const units = [
  {name: 'Unit', role: 'Jack', cost: 10}
];

class UnitTable extends React.Component {
  state = { source: units };

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

class DbxPlayers extends React.Component {
   render() {
         return (
	         <div>
	            <h1>DBX players</h1>
	            <UnitTable/>
	         </div>
         );
     };
};

export default DbxPlayers;
module.exports = DbxPlayers;
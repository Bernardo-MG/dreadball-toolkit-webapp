import React from 'react';
import { Table } from 'react-toolbox';

const UnitModel = {
  name: {type: String},
  role: {type: String},
  move: {type: Number},
  strength: {type: Number},
  speed: {type: Number},
  skill: {type: Number},
  armor: {type: Number},
  abilities: {type: Array},
  stranger_cost: {type: Number},
  ally_cost: {type: Number},
  friend_cost: {type: Number}
};

const DbxUnitTable = ({ source = [] }) => {
	return (
	  <Table
	    model={UnitModel}
	    source={source}
	    selectable={false}
	    multiSelectable={false}
	  />
	);
}

export default DbxUnitTable;

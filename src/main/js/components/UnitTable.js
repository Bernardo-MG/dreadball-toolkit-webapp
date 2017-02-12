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

const UnitTable = ({ source }) => {
	return (
	  <Table
	    model={UnitModel}
	    source={source}
	    selectable={false}
	    multiSelectable={false}
	  />
	);
}

export default UnitTable;
module.exports = UnitTable;
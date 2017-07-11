import React, { Component } from 'react';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import TableRow from 'grommet/components/TableRow';

import Button from 'grommet/components/Button';

import * as actions from 'builder/actions';

class AddUnitTableRow extends Component {

   unit;
   index;

   chooseUnit = () => {
      this.chooseSponsorUnit(this.unit);
   };

   constructor(props) {
      super(props);

      this.unit = props.source.templateName;
      this.index = props.index;
      
      this.chooseSponsorUnit = props.actions.chooseSponsorUnit;
   }

   render() {
      return (
         <TableRow key={this.index}>
            <td><Button label='add' onClick={this.chooseUnit} /></td>
            <td>{this.props.source.name}</td>
            <td>{this.props.source.role}</td>
            <td>{this.props.source.move}</td>
            <td>{this.props.source.strength}</td>
            <td>{this.props.source.speed}</td>
            <td>{this.props.source.skill}</td>
            <td>{this.props.source.armor}</td>
            <td>{this.props.source.abilities}</td>
            <td>{this.props.source.cost}</td>
         </TableRow>
      );
   }
}

const mapStateToProps = (state) => {
   return {}
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(actions, dispatch)
   }
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AddUnitTableRow);

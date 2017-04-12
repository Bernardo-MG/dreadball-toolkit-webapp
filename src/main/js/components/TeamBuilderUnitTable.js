import React from 'react';
import { Table } from 'react-toolbox';
import { injectIntl } from 'react-intl';
import unitMessages from 'i18n/unit';

class TeamBuilderUnitTable extends React.Component {
   UnitModel = {}
   
   constructor(props) {
      super(props);
      this.UnitModel = {
         position: {type: Number, title: props.intl.formatMessage(unitMessages.position)},
         name: {type: String, title: props.intl.formatMessage(unitMessages.name)},
         role: {type: String, title: props.intl.formatMessage(unitMessages.role)},
         move: {type: Number, title: props.intl.formatMessage(unitMessages.move)},
         strength: {type: Number, title: props.intl.formatMessage(unitMessages.strength)},
         speed: {type: Number, title: props.intl.formatMessage(unitMessages.speed)},
         skill: {type: Number, title: props.intl.formatMessage(unitMessages.skill)},
         armor: {type: Number, title: props.intl.formatMessage(unitMessages.armor)},
         abilities: {type: String, title: props.intl.formatMessage(unitMessages.abilities)},
         cost: {type: Number, title: props.intl.formatMessage(unitMessages.cost)}
      };
   }  
   
   render() {
      return (
         <Table
            model={this.UnitModel}
            source={this.props.source}
            selectable={false}
            multiSelectable={false} />
      );
   };
};

export default injectIntl(TeamBuilderUnitTable);
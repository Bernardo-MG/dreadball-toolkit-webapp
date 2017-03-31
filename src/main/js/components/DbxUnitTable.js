import React from 'react';
import { Table } from 'react-toolbox';
import { injectIntl } from 'react-intl';
import unitMessages from '../i18n/unit';

class DbxUnitTable extends React.Component {
   UnitModel = {}
   
   constructor(props) {
      super(props);
      this.UnitModel = {
         name: {type: String, title: props.intl.formatMessage(unitMessages.name)},
         role: {type: String, title: props.intl.formatMessage(unitMessages.role)},
         move: {type: Number, title: props.intl.formatMessage(unitMessages.move)},
         strength: {type: Number, title: props.intl.formatMessage(unitMessages.strength)},
         speed: {type: Number, title: props.intl.formatMessage(unitMessages.speed)},
         skill: {type: Number, title: props.intl.formatMessage(unitMessages.skill)},
         armor: {type: Number, title: props.intl.formatMessage(unitMessages.armor)},
         abilities: {type: String, title: props.intl.formatMessage(unitMessages.abilities)},
         stranger_cost: {type: Number, title: props.intl.formatMessage(unitMessages.stranger_cost)},
         ally_cost: {type: Number, title: props.intl.formatMessage(unitMessages.ally_cost)},
         friend_cost: {type: Number, title: props.intl.formatMessage(unitMessages.friend_cost)}
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

export default injectIntl(DbxUnitTable);
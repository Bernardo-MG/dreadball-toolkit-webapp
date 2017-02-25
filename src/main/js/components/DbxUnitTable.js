import React from 'react';
import { Table } from 'react-toolbox';
import { defineMessages, injectIntl } from 'react-intl';

const unitMessages = defineMessages({
  name: {
    id: 'unit.name',
    defaultMessage: 'Name',
  },
  role: {
    id: 'unit.role',
    defaultMessage: 'Role',
  },
  move: {
    id: 'unit.move',
    defaultMessage: 'Move',
  },
  strength: {
    id: 'unit.strength',
    defaultMessage: 'Strength',
  },
  speed: {
    id: 'unit.speed',
    defaultMessage: 'Speed',
  },
  skill: {
    id: 'unit.skill',
    defaultMessage: 'Skill',
  },
  armor: {
    id: 'unit.armor',
    defaultMessage: 'Armor',
  },
  abilities: {
    id: 'unit.abilities',
    defaultMessage: 'Abilities',
  },
  stranger_cost: {
    id: 'unit.cost.stranger',
    defaultMessage: 'Stranger cost',
  },
  ally_cost: {
    id: 'unit.cost.ally',
    defaultMessage: 'Ally cost',
  },
  friend_cost: {
    id: 'unit.cost.friend',
    defaultMessage: 'Friend cost',
  }
});

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
                multiSelectable={false}
              />
         );
     };
};

export default injectIntl(DbxUnitTable);

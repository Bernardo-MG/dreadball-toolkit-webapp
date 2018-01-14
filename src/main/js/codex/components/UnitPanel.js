import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Columns from 'grommet/components/Columns';
import Value from 'grommet/components/Value';

import abilityMessages from 'i18n/ability';
import unitMessages from 'i18n/unit';
import unitRoleMessages from 'i18n/role';

class UnitPanel extends Component {

   render() {
      let friendCost;
      let allyCost;
      let strangerCost;
      let cost;

      if (this.props.source.friendCost) {
         friendCost =
            <Box pad='small'>
               <Value value={this.props.source.friendCost} label={this.props.intl.formatMessage(unitMessages.friend_cost)} size='small' />
            </Box>;
      } else {
         friendCost = null;
      }
      if (this.props.source.allyCost) {
         allyCost =
            <Box pad='small'>
               <Value value={this.props.source.allyCost} label={this.props.intl.formatMessage(unitMessages.ally_cost)} size='small' />
            </Box>;
      } else {
         allyCost = null;
      }
      if (this.props.source.strangerCost) {
         strangerCost =
            <Box pad='small'>
               <Value value={this.props.source.strangerCost} label={this.props.intl.formatMessage(unitMessages.stranger_cost)} size='small' />
            </Box>;
      } else {
         strangerCost = null;
      }
      if (this.props.source.cost) {
         cost =
            <Box pad='small'>
               <Value value={this.props.source.cost} label={this.props.intl.formatMessage(unitMessages.cost)} size='small' />
            </Box>;
      } else {
         cost = null;
      }

      const costs =
         <Columns size='small'>
            {friendCost}
            {allyCost}
            {strangerCost}
            {cost}
         </Columns>;

      return (
         <Box>
            <Box>{this.props.intl.formatMessage(unitMessages.role)}: {this.props.intl.formatMessage(unitRoleMessages[this.props.source.role])}</Box>
            <Box>{this.props.intl.formatMessage(unitMessages.abilities)}: {this.props.source.abilities.map((a) => this.props.intl.formatMessage(abilityMessages[a])).join(', ')}</Box>
            <Box>
               <Columns size='small'>
                  <Box pad='small'>
                     <Value value={this.props.source.movement} label={this.props.intl.formatMessage(unitMessages.move)} size='small' />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.strength} label={this.props.intl.formatMessage(unitMessages.strength)} size='small' />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.speed} label={this.props.intl.formatMessage(unitMessages.speed)} size='small' />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.skill} label={this.props.intl.formatMessage(unitMessages.skill)} size='small' />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.armor} label={this.props.intl.formatMessage(unitMessages.armor)} size='small' />
                  </Box>
               </Columns>
            </Box>
            {costs}
         </Box>
      );
   }
}

UnitPanel.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(UnitPanel);

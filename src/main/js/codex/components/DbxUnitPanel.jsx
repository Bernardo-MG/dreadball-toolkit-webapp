import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Box from 'grommet/components/Box';
import Columns from 'grommet/components/Columns';
import Heading from 'grommet/components/Heading';
import Value from 'grommet/components/Value';

import abilityMessages from 'i18n/ability';
import unitMessages from 'i18n/unit';
import unitNameMessages from 'i18n/unitName';
import unitRoleMessages from 'i18n/role';

class DbxUnitPanel extends Component {

   render() {
      let friendCost;
      let allyCost;
      let strangerCost;
      let cost;

      if (this.props.source.friendCost) {
         friendCost =
            <Box pad='small'>
               <Value value={this.props.source.friendCost} label={this.props.intl.formatMessage(unitMessages.friend_cost)} />
            </Box>;
      } else {
         friendCost = null;
      }
      if (this.props.source.allyCost) {
         allyCost =
            <Box pad='small'>
               <Value value={this.props.source.allyCost} label={this.props.intl.formatMessage(unitMessages.ally_cost)} />
            </Box>;
      } else {
         allyCost = null;
      }
      if (this.props.source.strangerCost) {
         strangerCost =
            <Box pad='small'>
               <Value value={this.props.source.strangerCost} label={this.props.intl.formatMessage(unitMessages.stranger_cost)} />
            </Box>;
      } else {
         strangerCost = null;
      }
      if (this.props.source.cost) {
         cost =
            <Box pad='small'>
               <Value value={this.props.source.cost} label={this.props.intl.formatMessage(unitMessages.cost)} />
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
            <Heading tag='h1'>{this.props.intl.formatMessage(unitNameMessages[this.props.source.name])}</Heading>
            <Box>{this.props.intl.formatMessage(unitMessages.role)}: {this.props.intl.formatMessage(unitRoleMessages[this.props.source.role])}</Box>
            <Box>{this.props.intl.formatMessage(unitMessages.abilities)}: {this.props.source.abilities.map((a) => this.props.intl.formatMessage(abilityMessages[a])).join(', ')}</Box>
            <Box>
               <Columns size='small'>
                  <Box pad='small'>
                     <Value value={this.props.source.movement} label={this.props.intl.formatMessage(unitMessages.move)} />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.strength} label={this.props.intl.formatMessage(unitMessages.strength)} />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.speed} label={this.props.intl.formatMessage(unitMessages.speed)} />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.skill} label={this.props.intl.formatMessage(unitMessages.skill)} />
                  </Box>
                  <Box pad='small'>
                     <Value value={this.props.source.armor} label={this.props.intl.formatMessage(unitMessages.armor)} />
                  </Box>
               </Columns>
            </Box>
            {costs}
         </Box>
      );
   }
}

DbxUnitPanel.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(DbxUnitPanel);

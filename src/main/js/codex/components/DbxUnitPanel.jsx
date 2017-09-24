import React from 'react';

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

const DbxUnitPanel = (props) =>
   <Box>
      <Heading tag='h1'>{props.intl.formatMessage(unitNameMessages[props.source.name])}</Heading>
      <Box>{props.intl.formatMessage(unitMessages.role)}: {props.intl.formatMessage(unitRoleMessages[props.source.role])}</Box>
      <Box>{props.intl.formatMessage(unitMessages.abilities)}: {props.source.abilities.map((a) => props.intl.formatMessage(abilityMessages[a])).join(', ')}</Box>
      <Box>
         <Columns size='small'>
            <Box pad='small'>
               <Value value={props.source.movement} label={props.intl.formatMessage(unitMessages.move)} />
            </Box>
            <Box pad='small'>
               <Value value={props.source.strength} label={props.intl.formatMessage(unitMessages.strength)} />
            </Box>
            <Box pad='small'>
               <Value value={props.source.speed} label={props.intl.formatMessage(unitMessages.speed)} />
            </Box>
            <Box pad='small'>
               <Value value={props.source.skill} label={props.intl.formatMessage(unitMessages.skill)} />
            </Box>
            <Box pad='small'>
               <Value value={props.source.armor} label={props.intl.formatMessage(unitMessages.armor)} />
            </Box>
         </Columns>
      </Box>
      <Columns size='small'>
         <Box pad='small'>
            <Value value={props.source.friendCost} label={props.intl.formatMessage(unitMessages.friend_cost)} />
         </Box>
         <Box pad='small'>
            <Value value={props.source.allyCost} label={props.intl.formatMessage(unitMessages.ally_cost)} />
         </Box>
         <Box pad='small'>
            <Value value={props.source.strangerCost} label={props.intl.formatMessage(unitMessages.stranger_cost)} />
         </Box>
      </Columns>
   </Box>;

DbxUnitPanel.propTypes = {
   source: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(DbxUnitPanel);

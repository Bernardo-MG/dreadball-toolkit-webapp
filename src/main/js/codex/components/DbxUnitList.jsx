import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import List from 'grommet/components/List';
import ListItem from 'grommet/components/ListItem';

import unitNameMessages from 'i18n/unitName';

const DbxUnitList = (props) =>
   <List selectable={true} onSelect={props.onSelect} >
      { props.source.map((unit, i) =>
         <ListItem key={i}>
            <span>{props.intl.formatMessage(unitNameMessages[unit.name])}</span>
         </ListItem>
         )}
   </List>;

DbxUnitList.propTypes = {
   source: PropTypes.array.isRequired,
   onSelect: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

export default injectIntl(DbxUnitList);

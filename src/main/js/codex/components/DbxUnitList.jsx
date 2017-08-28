import React from 'react';

import PropTypes from 'prop-types';

import List from 'grommet/components/List';
import ListItem from 'grommet/components/ListItem';

const DbxUnitList = (props) =>
   <List selectable={true} onSelect={props.onSelect} >
      { props.source.map((object, i) =>
         <ListItem key={i}>
            <span>{object.name}</span>
         </ListItem>
         )}
   </List>;

DbxUnitList.propTypes = {
   source: PropTypes.array.isRequired,
   onSelect: PropTypes.func.isRequired
};

export default DbxUnitList;

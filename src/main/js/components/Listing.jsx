import React from 'react';

import PropTypes from 'prop-types';

import List from 'grommet/components/List';
import ListItem from 'grommet/components/ListItem';


const Listing = (props) => {
   return (
      <List>
         {props.source.map((element, i) => {
            let item;

            if (element) {
               item = <ListItem key={i} alignContent='center' full={ false } separator='horizontal'>{element}</ListItem>;
            } else {
               item = null;
            }

            return item;
         })}
      </List>
   );
};

Listing.propTypes = {
   source: PropTypes.array.isRequired
};

export default Listing;

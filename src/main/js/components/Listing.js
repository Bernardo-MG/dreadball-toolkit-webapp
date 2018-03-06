import React from 'react';

import PropTypes from 'prop-types';

import List from 'grommet/components/List';
import ListItem from 'grommet/components/ListItem';


const Listing = (props) =>
   <List>
      {props.source.map((element, i) => {
         let item;

         if (element) {
            if (i === 0) {
               item = <ListItem key={i} separator='horizontal'>{element}</ListItem>;
            } else {
               item = <ListItem key={i}>{element}</ListItem>;
            }
         } else {
            item = null;
         }

         return item;
      })}
   </List>;

Listing.propTypes = {
   source: PropTypes.array.isRequired
};

export default Listing;

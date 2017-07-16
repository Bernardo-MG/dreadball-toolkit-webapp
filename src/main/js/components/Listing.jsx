import React from 'react';

import List from 'grommet/components/List';
import ListItem from 'grommet/components/ListItem';


const Listing = (props) => {
   return (
      <List>
         {props.source.map((element, i) => {
            if(element){
               return (
                  <ListItem key={i} alignContent='center' full={ false } separator='horizontal'>{element}</ListItem>
               );
            } else {
               return null;
            }
         })}
      </List>
   );
};

export default Listing;

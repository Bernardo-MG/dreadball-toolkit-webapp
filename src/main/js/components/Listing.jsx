import React from 'react';
import ListItem from 'grommet/components/ListItem';


const Listing = (props) => {
   return (
      <div>
         {props.source.map((element, i) => {
            if(element){
               return (
                  <ListItem key={i} justify='between' separator='horizontal'>
                     <span>{element}</span>
                  </ListItem>
               );
            }
         })}
      </div>
   );
}

export default Listing;

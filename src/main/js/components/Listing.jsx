import React from 'react';
import List from 'grommet/components/List';
import ListItem from 'grommet/components/ListItem';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';


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

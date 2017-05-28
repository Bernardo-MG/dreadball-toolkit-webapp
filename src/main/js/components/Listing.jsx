import React, { Component } from 'react';
import List from 'grommet/components/List';
import ListItem from 'grommet/components/ListItem';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';


class Listing extends Component {

   render() {
      return (
         <div>
            {this.props.source.map((element, i) => {
               return (
                  <ListItem key={i} justify='between' separator='horizontal'>
                     <span>{element}</span>
                  </ListItem>
               );
            })}
         </div>
      );
   }
}

export default Listing;

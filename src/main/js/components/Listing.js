import React, { Component } from 'react';

import PropTypes from 'prop-types';

import List from 'grommet/components/List';
import ListItem from 'grommet/components/ListItem';

/**
 * List component. Creates a list from a collection of items.
 * 
 * The collection should contain a list of elements to show, which will be rendered
 * into the list.
 */
class Listing extends Component {

   /**
    * Renders an element at the specified index.
    * 
    * @param element element to render
    * @param i element index
    */
   _renderItem(element, i) {
      let item;

      if (i === 0) {
         item = <ListItem key={i} separator='horizontal'>{element}</ListItem>;
      } else {
         item = <ListItem key={i}>{element}</ListItem>;
      }

      return item;
   }

   render() {
      return <List>
         {this.props.source.map((element, i) => this._renderItem(element, i))}
      </List>;
   }

}

Listing.propTypes = {
   /** Elements to render */
   source: PropTypes.array.isRequired
};

export default Listing;

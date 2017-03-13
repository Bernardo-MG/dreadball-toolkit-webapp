import React from 'react';
import Combobox from './Combobox';

const ComboPanel = (props) => {
   if (props.source) {
      return (
         <div>
            {props.source.map(function(element, i) {
               return (
                  <Combobox key={i} source={element} />
               );
            })}
         </div>
      );
   } else {
      return (
         <div/>
      );
   }
};

export default ComboPanel;
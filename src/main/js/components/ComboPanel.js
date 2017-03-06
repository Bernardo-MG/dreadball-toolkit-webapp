import React from 'react';
import Combobox from './Combobox';

const ComboPanel = (props) => {
   return (
      <div>
         {props.source.map(function(element, i) {
            return (
               <Combobox key={i} source={element} />
            );
         })}
      </div>
   );
};

export default ComboPanel;
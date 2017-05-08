import React from 'react'

const ComponentPanel = (props) => {
   return (
      <div>
         {props.source.map(function(element, i) {
            return (
               <props.type index={i} key={i} source={element} />
            );
         })}
      </div>
   );
};

export default ComponentPanel;
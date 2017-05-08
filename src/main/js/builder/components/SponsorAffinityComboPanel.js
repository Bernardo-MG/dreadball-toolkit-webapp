import React from 'react'

const SponsorAffinityComboPanel = (props) => {
   if (props.source.length) {
      return (
         <div>
            {props.source.map(function(element, i) {
               return (
                  <props.type index={i} key={i} source={element} />
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

export default SponsorAffinityComboPanel;
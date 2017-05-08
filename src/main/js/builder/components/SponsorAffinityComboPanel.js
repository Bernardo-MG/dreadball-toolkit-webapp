import React from 'react'
import SponsorAffinityComboBox from 'builder/containers/SponsorAffinityComboBox';

const SponsorAffinityComboPanel = (props) => {
   if (props.source.length) {
      return (
         <div>
            {props.source.map(function(element, i) {
               return (
                  <SponsorAffinityComboBox index={i} key={i} source={element} />
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
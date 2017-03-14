import React from 'react';
import SponsorAffinityComboBox from '../containers/SponsorAffinityComboBox';

const ComboPanel = (props) => {
   if (props.source) {
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

export default ComboPanel;
import React from 'react';
import SponsorAffinityComboBox from 'builder/containers/SponsorAffinityComboBox';

const SponsorAffinitySelectField = (props) => {
   return (
      <div>
         {props.source.map((element, i) => {
            return (
               <SponsorAffinityComboBox index={i} key={i} source={element} />
            );
         })}
      </div>
   );
};

export default SponsorAffinitySelectField;

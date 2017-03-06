import React from 'react';
import Combobox from './Combobox';

const affinities = [
   { value: 'affinity1', label: 'affinity1' },
   { value: 'affinity2', label: 'affinity2'},
   { value: 'affinity3', label: 'affinity3' },
   { value: 'affinity4', label: 'affinity4'},
   { value: 'affinity5', label: 'affinity5'},
   { value: 'affinity6', label: 'affinity6'}
];

const values = [ affinities, affinities, affinities, affinities, affinities ];

const ComboPanel = () => {
   return (
      <div>
         {values.map(function(element, i) {
            return (
               <Combobox source={element} />
            );
         })}
      </div>
   );
};

export default ComboPanel;
import React from 'react';
import Combobox from './Combobox';

const values = [
   { value: 'affinity1', label: 'affinity1' },
   { value: 'affinity2', label: 'affinity2'},
   { value: 'affinity3', label: 'affinity3' },
   { value: 'affinity4', label: 'affinity4'},
   { value: 'affinity5', label: 'affinity5'},
   { value: 'affinity6', label: 'affinity6'}
];

const ComboPanel = () => {
   return (
      <div>
         <Combobox source={values} />
         <Combobox source={values} />
      </div>
   );
};

export default ComboPanel;
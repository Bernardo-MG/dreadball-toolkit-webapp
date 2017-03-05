import React from 'react';
import Dropdown from 'react-toolbox/lib/dropdown';

const values = [
   { value: 'affinity1', label: 'affinity1' },
   { value: 'affinity2', label: 'affinity2'},
   { value: 'affinity3', label: 'affinity3' },
   { value: 'affinity4', label: 'affinity4'},
   { value: 'affinity5', label: 'affinity5'},
   { value: 'affinity6', label: 'affinity6'}
];

class AffinityCombo extends React.Component {
   state = { value: 'affinity1' };

   handleChange = (value) => {
      this.setState({value: value});
   };
   
   render() {
      return (
         <Dropdown
            auto
            onChange={this.handleChange}
            source={values}
            value={this.state.value}
         />
      );
   };
};

export default AffinityCombo;
import React, { Component } from 'react';
import NumberInput from 'grommet/components/NumberInput';

class BoundNumberInput extends Component {

   state = {};
   handleChange;

   constructor(props) {
      super(props);

      this.handleChange = props.handleChange;
   }

   updateValue = (event) => {
      this.handleChange(Number.parseInt(event.target.value));
   };

   render() {
      return (
         <NumberInput {...this.props} onChange={this.updateValue} />
      );
   }
}

export default BoundNumberInput;

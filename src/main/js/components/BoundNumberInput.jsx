import React, { Component } from 'react';
import NumberInput from 'grommet/components/NumberInput';

class BoundNumberInput extends Component {

   state = { };

   constructor(props) {
      super(props);

      this.state.value = props.value;
   }

   updateValue = (event) => {
      this.setState({ value: event.target.value });
   };

   render() {
      return (
         <NumberInput {...this.props} onChange={this.updateValue} />
      );
   }
}

export default BoundNumberInput;

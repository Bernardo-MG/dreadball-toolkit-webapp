import React, { Component } from 'react';

import PropTypes from 'prop-types';

import NumberInput from 'grommet/components/NumberInput';

class BoundNumberInput extends Component {

   state = {};
   handleChange;

   constructor(props) {
      super(props);

      this.handleChange = props.handleChange;
   }

   updateValue = (event) => {
      if (event.target.value) {
         this.handleChange(Number.parseInt(event.target.value, 10));
      } else {
         this.setState({ value: 0 });
      }
   };

   render() {
      return (
         <NumberInput {...this.props} onChange={this.updateValue} />
      );
   }
}

BoundNumberInput.propTypes = {
   handleChange: PropTypes.func.isRequired
};

export default BoundNumberInput;

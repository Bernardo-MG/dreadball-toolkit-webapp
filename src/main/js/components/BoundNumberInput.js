import React, { Component } from 'react';

import PropTypes from 'prop-types';

import NumberInput from 'grommet/components/NumberInput';

class BoundNumberInput extends Component {

   handleChange;

   constructor(props) {
      super(props);

      this.handleChange = props.handleChange;
   }

   _onUpdateValue(event) {
      if (event.target.value) {
         this.handleChange(Number.parseInt(event.target.value, 10));
      } else {
         this.handleChange(0);
      }
   }

   render() {
      const { handleChange, action, ...rest } = this.props;
      const updateValue = this._onUpdateValue.bind(this);
      return (
         <NumberInput {...rest} onChange={updateValue} />
      );
   }
}

BoundNumberInput.propTypes = {
   handleChange: PropTypes.func.isRequired,
   action: PropTypes.func.isRequired
};

export default BoundNumberInput;

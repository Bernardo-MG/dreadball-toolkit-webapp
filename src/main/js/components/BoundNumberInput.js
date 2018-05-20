import React, { Component } from 'react';

import PropTypes from 'prop-types';

import NumberInput from 'grommet/components/NumberInput';

class BoundNumberInput extends Component {

   onChange;

   constructor(props) {
      super(props);

      this.onChange = props.onChange;
   }

   _onUpdateValue(event) {
      if (event.target.value) {
         this.onChange(Number.parseInt(event.target.value, 10));
      } else {
         this.onChange(0);
      }
   }

   render() {
      const { onChange, ...rest } = this.props;
      const updateValue = this._onUpdateValue.bind(this);
      return (
         <NumberInput {...rest} onChange={updateValue} />
      );
   }
}

BoundNumberInput.propTypes = {
   onChange: PropTypes.func.isRequired
};

export default BoundNumberInput;

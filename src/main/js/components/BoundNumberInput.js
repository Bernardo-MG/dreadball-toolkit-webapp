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
      const updateValue = this._onUpdateValue.bind(this);
      return (
         <NumberInput id={this.props.id} name={this.props.name} value={this.props.value} min={this.props.min} max={this.props.max} onChange={updateValue} />
      );
   }
}

BoundNumberInput.propTypes = {
   onChange: PropTypes.func.isRequired,
   id: PropTypes.string,
   name: PropTypes.string,
   min: PropTypes.number,
   max: PropTypes.number,
   value: PropTypes.number
};

export default BoundNumberInput;

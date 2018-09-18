import React, { Component } from 'react';

import PropTypes from 'prop-types';

import NumberInput from 'grommet/components/NumberInput';

/**
 * Number input with a custom change listener. Allows reacting to changes on the stored value.
 */
class ObservableNumberInput extends Component {

   /** Custom value change listener */
   onChange;

   /**
    * Handles the value change event. It will send the selected to the custom change listener.
    * 
    * @param event value change event
    */
   _onHandleChange(event) {
      if (this.onChange) {
         if (event.target.value) {
            this.onChange(Number.parseInt(event.target.value, 10));
         } else {
            // No value received, input empty
            this.onChange(0);
         }
      }
   }

   constructor(props) {
      super(props);

      this.onChange = props.onChange;
   }

   render() {
      const handleChange = this._onHandleChange.bind(this);
      return (
         <NumberInput
            id={this.props.id}
            name={this.props.name}
            value={this.props.value}
            min={this.props.min}
            max={this.props.max}
            onChange={handleChange} />
      );
   }
}

ObservableNumberInput.propTypes = {
   /** Custom value change listener */
   onChange: PropTypes.func.isRequired,
   /** DOM id value */
   id: PropTypes.string,
   /** DOM name value */
   name: PropTypes.string,
   /** Minimum allowed value */
   min: PropTypes.number,
   /** Maximum allowed value */
   max: PropTypes.number,
   /** Stored and shown value */
   value: PropTypes.number
};

export default ObservableNumberInput;

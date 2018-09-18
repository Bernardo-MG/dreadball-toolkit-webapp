import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Select from 'grommet/components/Select';

/**
 * Combobox. Allows selecting a value from a set of options.
 * 
 * It requires a collection of values which will be used as the options of the combobox. Each of these values
 * should be a map containing a 'value' and 'label' keys. The first for the stored value, the second for the
 * text shown for the value.
 * 
 * It requires a listener, as the onChange property, which will be called whenever an option is
 * selected, using the selected value as argument.
 */
class Combo extends Component {

   /** Component state */
   state = {};

   /** Custom value change listener */
   onChange;

   /**
    * Handles the value change event. It will set the selected value into the state,
    * and then send it to the custom change listener.
    * 
    * @param event value change event
    */
   _onHandleChange(event) {
      const selected = event.option;

      this.setState({
         option: selected
      });

      if (this.onChange) {
         this.onChange(selected.value);
      }
   }

   constructor(props) {
      super(props);

      this.onChange = props.onChange;
   }

   render() {
      const handleChange = this._onHandleChange.bind(this);
      return (
         <Select
            placeHolder={this.props.placeHolder}
            options={this.props.source}
            value={this.state.option}
            onChange={handleChange} />
      );
   }
}

Combo.propTypes = {
   /** Options for the combobox */
   source: PropTypes.array.isRequired,
   /** Custom value change listener */
   onChange: PropTypes.func.isRequired,
   /** Text to show when no option has been selected */
   placeHolder: PropTypes.string
};

export default Combo;

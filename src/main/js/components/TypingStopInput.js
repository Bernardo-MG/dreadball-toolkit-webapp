import React, { Component } from 'react';

import PropTypes from 'prop-types';

/**
 * Text input which calls the change event after the user stops typing.
 */
class TypingStopInput extends Component {

   /** Custom value change listener */
   onChange;

   /** Timer to wait for the user to end typing */
   timer;

   /**
    * Handles the value change event. It use a timer to fire the custom event
    * once the user has stopped typing.
    * 
    * @param event value change event
    */
   _onHandleChange(event) {
      if (this.timer) {
         clearTimeout(this.timer);
      }

      const value = event.target.value;

      this.timer = setTimeout(() => {
         this.onChange(value);
      }, 1000);
   }

   constructor(props) {
      super(props);

      this.onChange = this.props.onChange;
   }

   render() {
      return <input id={ this.props.id } name={ this.props.name } type='text' onChange={ ::this._onHandleChange }/>;
   }

}

TypingStopInput.propTypes = {
   /** Id for the input */
   id: PropTypes.string.isRequired,
   /** Name for the input */
   name: PropTypes.string.isRequired,
   /** Custom value change listener */
   onChange: PropTypes.func.isRequired
};

export default TypingStopInput;

import React, { Component } from 'react';

import PropTypes from 'prop-types';

class DelayedTextInput extends Component {

   value;
   onChange;
   timer;

   _handleChange(event) {
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
      return <input id={ this.props.id } name={ this.props.name } type='text' onChange={ ::this._handleChange }/>;
   }

}

DelayedTextInput.propTypes = {
   id: PropTypes.string.isRequired,
   name: PropTypes.string.isRequired,
   onChange: PropTypes.func.isRequired,
   label: PropTypes.string.isRequired
};

export default DelayedTextInput;

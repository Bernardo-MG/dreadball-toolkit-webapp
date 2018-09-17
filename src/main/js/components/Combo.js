import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Select from 'grommet/components/Select';

class Combo extends Component {

   state = {};
   index;
   onChange;

   handleChange = (value) => {
      const selected = value.option;

      this.setState({
         option: selected
      });

      this.onChange(selected.value, this.index);
   };

   constructor(props) {
      super(props);

      this.index = props.index;
      this.onChange = props.onChange;
   }

   render() {
      return (
         <Select
            placeHolder={this.props.placeHolder}
            options={this.props.source}
            value={this.state.option}
            onChange={this.handleChange} />
      );
   }
}

Combo.propTypes = {
   onChange: PropTypes.func.isRequired,
   index: PropTypes.number.isRequired,
   source: PropTypes.array.isRequired,
   placeHolder: PropTypes.string
};

export default Combo;

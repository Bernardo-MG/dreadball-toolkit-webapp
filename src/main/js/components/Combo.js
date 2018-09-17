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

   componentDidMount() {
      if (this.state.option) {
         this.props.onChange(this.state.option.value, this.index);
      }
   }

   constructor(props) {
      super(props);

      this.index = props.index;
      this.onChange = props.onChange;

      if (props.source.length) {
         const first = props.source[0];
         this.state = {
            option: first
         };
      }
   }

   render() {
      return (
         <Select placeHolder='None'
            options={this.props.source}
            value={this.state.option}
            onChange={this.handleChange} />
      );
   }
}

Combo.propTypes = {
   onChange: PropTypes.func.isRequired,
   index: PropTypes.number.isRequired,
   source: PropTypes.array.isRequired
};

export default Combo;

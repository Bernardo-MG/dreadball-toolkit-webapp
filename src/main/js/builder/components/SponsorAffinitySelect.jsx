import React, { Component } from 'react';

import PropTypes from 'prop-types';

import Select from 'grommet/components/Select';

class SponsorAffinitySelect extends Component {

   state = {};
   index;
   onChange;

   handleChange = (value) => {
      const selected = value.option.value;
      let affinity;

      if (value.option.rank) {
         affinity = value.option.value;
      } else {
         affinity = value.option.affinity;
      }

      this.setState({
         affinity,
         value: selected
      });

      this.onChange(affinity, this.index);
   };

   componentDidMount() {
      this.props.onChange(this.state.value, this.index);
   }

   constructor(props) {
      super(props);

      this.index = props.index;
      this.onChange = props.onChange;

      if(props.source.length) {
         const first = props.source[0];
         this.state = {
            affinity: first.affinity,
            value: first.value
         };
      }
   }

   render() {
      return (
         <Select placeHolder='None'
            options={this.props.source}
            value={this.state.value}
            onChange={this.handleChange} />
      );
   }
}

SponsorAffinitySelect.propTypes = {
   onChange: PropTypes.func.isRequired,
   index: PropTypes.number.isRequired,
   source: PropTypes.array.isRequired
};

export default SponsorAffinitySelect;

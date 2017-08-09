import React, { Component } from 'react';
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

      const first = props.source[0];
      this.state.affinity = first.affinity;
      this.state.value = first.value;
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

export default SponsorAffinitySelect;

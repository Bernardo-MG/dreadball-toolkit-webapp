import React, { Component } from 'react';
import Select from 'grommet/components/Select';

class SponsorAffinitySelect extends Component {

   state = {};
   index;
   handleSelection;

   handleChange = (value) => {
      const selected = value.option.value;
      const affinity = value.option.affinity;
      const rank = value.option.rank;
      this.setState({
         affinity,
         rank,
         value: selected
      });

      this.handleSelection(affinity, rank, this.index);
   };

   componentDidMount() {
      this.props.handleSelection(this.state.value, this.state.rank, this.index);
   }

   constructor(props) {
      super(props);

      this.index = props.index;
      this.handleSelection = props.handleSelection;

      const first = props.source[0];
      this.state.affinity = first.affinity;
      this.state.value = first.value;
      this.state.rank = first.rank;
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

import React from 'react';
import Dropdown from 'react-toolbox/lib/dropdown';


class Combobox extends React.Component {
   state = {};

   handleChange = (value) => {
      this.setState({value: value});
   };
   
   render() {
      return (
         <Dropdown
            auto
            allowBlank={false}
            onChange={this.handleChange}
            source={this.props.source}
            value={this.state.value}
         />
      );
   };
};

export default Combobox;
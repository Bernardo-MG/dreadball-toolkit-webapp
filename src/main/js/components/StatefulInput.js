import React, { Component } from 'react';
import Input from 'react-toolbox/lib/input';

class StatefulInput extends React.Component {
   state = { text: '' };
   
   handleChange = (value) => {
      this.setState({text: value});
   };
   
   render () {
      return (
         <Input {...this.props} value={this.state.text} onChange={this.handleChange.bind(this)} />
      );
   }
}

export default StatefulInput;
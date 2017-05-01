import React, { Component } from 'react'
//import Dropdown from 'react-toolbox/lib/dropdown';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'actions/dbxBuilder';

class SponsorAffinityComboBox extends Component {

   state = {};
   index;

   handleChange = (value) => {
      this.setState({value: value});
      this.props.actions.chooseSponsorAffinity(this.state.value, this.index);
   };
   
   constructor(props) {
      super(props);
      this.index = props.index;
      this.state.value = props.source[0].value;
   }
   
   componentDidMount() {
      this.props.actions.chooseSponsorAffinity(this.state.value, this.index);
   }
   
   render() {
      return (
         <div/>
         //<Dropdown
         //   auto
         //   allowBlank={false}
         //   onChange={this.handleChange}
         //   source={this.props.source}
         //   value={this.state.value}
         ///>
      );
   };
};

const mapStateToProps = (state) => ({
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityComboBox);
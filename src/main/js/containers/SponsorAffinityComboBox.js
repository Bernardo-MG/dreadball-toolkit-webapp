import React, { Component } from 'react'
import Select from 'grommet/components/Select';
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
         <Select placeHolder='None'
            options={this.props.source}
            value={this.state.value}
            onChange={this.handleChange} />
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
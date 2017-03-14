import React from 'react';
import Dropdown from 'react-toolbox/lib/dropdown';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from '../actions/dbxBuilder';

class SponsorAffinityComboBox extends React.Component {

   state = {};
   index;

   handleChange = (value) => {
      this.setState({value: value});
      this.props.actions.chooseSponsorAffinity(value, this.index);
   };
   
   constructor(props) {
      super(props);
      this.index = props.index;
   }
   
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

const mapStateToProps = (state) => ({
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityComboBox);
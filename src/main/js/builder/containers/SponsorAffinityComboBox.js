import React, { Component } from 'react';
import Select from 'grommet/components/Select';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';

class SponsorAffinityComboBox extends Component {

   state = {};
   index;

   handleChange(value) {
      const selected = value.option.value;
      const affinity = value.option.affinity;
      const rank = value.option.rank;
      this.setState({
            value: selected, 
            affinity, 
            rank 
         });
      this.props.actions.chooseSponsorAffinity(affinity, rank, this.index);
   };

   constructor(props) {
      super(props);
      this.index = props.index;
      this.state.affinity = props.source[0].affinity;
      this.state.value = props.source[0].value;
      this.state.rank = props.source[0].rank;
   }

   componentDidMount() {
      this.props.actions.chooseSponsorAffinity(this.state.value, this.state.rank, this.index);
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

const mapStateToProps = () => {
};

const mapDispatchToProps = (dispatch) => {
   actions: bindActionCreators(Actions, dispatch)
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityComboBox);

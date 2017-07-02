import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import BoundNumberInput from 'components/BoundNumberInput';

class SponsorRankBoundNumberInput extends Component {

   handleChange;
   reloadSponsorRank;

   setValue = (value) => {
      this.handleChange(value);
      this.reloadSponsorRank();
   };

   constructor(props) {
      super(props);

      this.handleChange = props.handleChange;
      this.reloadSponsorRank = props.actions.reloadSponsorRank;
   }

   render() {
      return (
         <BoundNumberInput {...this.props} handleChange={this.setValue} />
      );
   }
}

const mapStateToProps = (state) => {
   return {}
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(Actions, dispatch)
   }
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorRankBoundNumberInput);

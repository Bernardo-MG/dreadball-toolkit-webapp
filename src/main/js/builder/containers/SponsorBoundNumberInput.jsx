import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import BoundNumberInput from 'components/BoundNumberInput';

class SponsorBoundNumberInput extends Component {

   handleChange;
   reloadSponsorRank;
   reloadSponsorTeamValue;

   setValue = (value) => {
      this.handleChange(value);
      this.reloadSponsorRank();
      this.reloadSponsorTeamValue();
   };

   constructor(props) {
      super(props);

      this.handleChange = props.handleChange;
      this.reloadSponsorRank = props.actions.reloadSponsorRank;
      this.reloadSponsorTeamValue = props.actions.reloadSponsorTeamValue;
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
)(SponsorBoundNumberInput);

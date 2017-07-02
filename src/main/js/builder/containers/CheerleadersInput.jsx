import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import BoundNumberInput from 'components/BoundNumberInput';

class CheerleadersInput extends Component {

   updateSponsorCheerleaders;
   reloadSponsorRank;

   setValue = (value) => {
      this.updateSponsorCheerleaders(value);
      this.reloadSponsorRank();
   };

   constructor(props) {
      super(props);

      this.updateSponsorCheerleaders = props.actions.updateSponsorCheerleaders;
      this.reloadSponsorRank = props.actions.reloadSponsorRank;
   }

   render() {
      return (
         <BoundNumberInput {...this.props} handleChange={this.setValue} />
      );
   }
}

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.cheerleaders
   }
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(Actions, dispatch)
   }
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CheerleadersInput);

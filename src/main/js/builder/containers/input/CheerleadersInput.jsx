import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';
import SponsorBoundNumberInput from 'builder/containers/input/SponsorBoundNumberInput';

const CheerleadersInput = (props) => {
   return (
      <SponsorBoundNumberInput {...props}
         handleChange={props.actions.updateSponsorCheerleaders}
         updateSponsor={(value, sponsor) => sponsor.cheerleaders = value}/>
   );
};

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.cheerleaders
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(Actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CheerleadersInput);

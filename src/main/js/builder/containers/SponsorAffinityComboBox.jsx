import React from 'react';
import SponsorAffinitySelect from 'builder/components/SponsorAffinitySelect';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';

const SponsorAffinityComboBox = (props) => {
   return (
      <SponsorAffinitySelect index={props.index} source={props.source} onChange={props.actions.chooseSponsorAffinity} />
   );
};

const mapStateToProps = (state) => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(Actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityComboBox);

import React from 'react';
import Select from 'grommet/components/Select';
import SponsorAffinitySelect from 'builder/components/SponsorAffinitySelect';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';

const SponsorAffinityComboBox = (props) => {
   return (
      <SponsorAffinitySelect index={props.index} source={props.source} handleSelection={props.actions.chooseSponsorAffinity} />
   );
}

const mapStateToProps = (state) => ({
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityComboBox);

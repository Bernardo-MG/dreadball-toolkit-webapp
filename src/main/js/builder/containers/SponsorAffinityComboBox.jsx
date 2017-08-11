import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import SponsorAffinitySelect from 'builder/components/SponsorAffinitySelect';

import * as Actions from 'builder/actions';

const SponsorAffinityComboBox = (props) =>
   <SponsorAffinitySelect index={props.index} source={props.source} onChange={props.actions.chooseSponsorAffinity} />;

SponsorAffinityComboBox.propTypes = {
   index: PropTypes.number.isRequired,
   source: PropTypes.object.isRequired,
   actions: PropTypes.object.isRequired
};

const mapStateToProps = () => {
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

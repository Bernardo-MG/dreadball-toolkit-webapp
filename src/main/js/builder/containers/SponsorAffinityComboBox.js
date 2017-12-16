import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import SponsorAffinitySelect from 'builder/components/SponsorAffinitySelect';

import { chooseSponsorAffinity } from 'builder/actions';

const SponsorAffinityComboBox = (props) =>
   <SponsorAffinitySelect index={props.index} source={props.source} onChange={props.action} />;

SponsorAffinityComboBox.propTypes = {
   index: PropTypes.number.isRequired,
   source: PropTypes.array.isRequired,
   action: PropTypes.func.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(chooseSponsorAffinity, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityComboBox);

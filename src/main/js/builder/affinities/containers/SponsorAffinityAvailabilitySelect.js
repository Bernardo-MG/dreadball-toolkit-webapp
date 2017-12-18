import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import AffinityAvailabilitySelect from 'builder/affinities/components/AffinityAvailabilitySelect';

import { chooseSponsorAffinity } from 'builder/actions';

const SponsorAffinityAvailabilitySelect = (props) =>
   <AffinityAvailabilitySelect index={props.index} source={props.source} onChange={props.action} />;

SponsorAffinityAvailabilitySelect.propTypes = {
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
)(SponsorAffinityAvailabilitySelect);

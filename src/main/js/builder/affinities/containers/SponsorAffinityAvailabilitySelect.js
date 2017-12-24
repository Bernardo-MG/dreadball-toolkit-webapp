import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import AffinityAvailabilitySelect from 'builder/affinities/components/AffinityAvailabilitySelect';

import { chooseSponsorAffinity } from 'builder/actions';

import affinitiesMessages from 'i18n/affinity';

function internationalize(option, intl) {
   return { value: option.value, label: intl.formatMessage(affinitiesMessages[option.label]) };
}

class SponsorAffinityAvailabilitySelect extends Component {

   values;

   constructor(props) {
      super(props);

      this.values = this.props.source.map((option) => internationalize(option, props.intl));
   }

   render() {
      return (
         <AffinityAvailabilitySelect index={this.props.index} source={this.values} onChange={this.props.action} />
      );
   }
}

SponsorAffinityAvailabilitySelect.propTypes = {
   index: PropTypes.number.isRequired,
   source: PropTypes.array.isRequired,
   action: PropTypes.func.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(chooseSponsorAffinity, dispatch)
   };
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityAvailabilitySelect));

import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetchAffinityOptions as fetch } from 'builder/affinities/actions';

import { selectAffinityOptions } from 'builder/affinities/selectors';

import SponsorAffinityAvailabilitySelectField from 'builder/affinities/components/SponsorAffinityAvailabilitySelectField';

class SponsorAffinityAvailabilitySelectionPanel extends Component {

   componentDidMount() {
      this.props.action();
   }

   render() {
      return (
         <SponsorAffinityAvailabilitySelectField source={this.props.source} />
      );
   }

}

SponsorAffinityAvailabilitySelectionPanel.propTypes = {
   action: PropTypes.func.isRequired,
   source: PropTypes.array.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: selectAffinityOptions(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(fetch, dispatch)
   };
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityAvailabilitySelectionPanel));

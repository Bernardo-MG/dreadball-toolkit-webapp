import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetch } from 'models/actions/sponsorAffAva';

import { selectSponsorAffAvas } from 'models/selectors';

import { avasToMap } from 'builder/views/tools';

import SponsorAffinityAvailabilitySelectField from 'builder/affinities/components/SponsorAffinityAvailabilitySelectField';

class SponsorAffinityAvailabilitySelectionPanel extends Component {

   values;

   constructor(props) {
      super(props);

      this.values = avasToMap(props.source, props.intl);
   }

   componentDidMount() {
      this.props.action();
   }

   componentWillReceiveProps(props) {
      this.values = avasToMap(props.source, props.intl);
   }

   render() {
      return (
         <SponsorAffinityAvailabilitySelectField source={this.values} />
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
      source: selectSponsorAffAvas(state)
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

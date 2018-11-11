import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Box from 'grommet/components/Box';

import { fetchAffinityOptions as fetch } from 'builder/requests/affinities/actions';
import { chooseSponsorAffinity } from 'builder/actions';

import { selectAffinityOptions } from 'builder/affinities/selectors';

import Combo from 'components/Combo';

import affinitiesMessages from 'i18n/affinity';
import teamBuilderMessages from 'i18n/teamBuilder';

function internationalizeOption(option, intl) {
   return { value: option, label: intl.formatMessage(affinitiesMessages[option]) };
}

function internationalizeOptions(options, intl) {
   const result = [];
   options.forEach((option) => result.push(internationalizeOption(option, intl)));
   return result;
}

class SponsorAffinityAvailabilitySelectionPanel extends Component {

   componentDidMount() {
      this.props.load();
   }

   render() {
      return (
         <Box>
            {this.props.source.map((element, i) => <Combo key={i} placeHolder={this.props.intl.formatMessage(teamBuilderMessages.pick_affinity)} source={internationalizeOptions(element.options, this.props.intl)} onChange={(v) => this.props.action(v, i)} />)}
         </Box>
      );
   }

}

SponsorAffinityAvailabilitySelectionPanel.propTypes = {
   action: PropTypes.func.isRequired,
   load: PropTypes.func.isRequired,
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
      load: bindActionCreators(fetch, dispatch),
      action: bindActionCreators(chooseSponsorAffinity, dispatch)
   };
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityAvailabilitySelectionPanel));

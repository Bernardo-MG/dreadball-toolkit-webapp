import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Box from 'grommet/components/Box';

import { fetchAffinityOptions as fetch } from 'builder/affinities/actions';
import { chooseSponsorAffinity } from 'builder/actions';

import { selectAffinityOptions } from 'builder/affinities/selectors';

import Combo from 'components/Combo';

import affinitiesMessages from 'i18n/affinity';

function internationalizeOption(option, intl) {
   return { value: option.value, label: intl.formatMessage(affinitiesMessages[option.label]) };
}

function internationalizeOptions(options, intl) {
   const result = [];
   options.forEach((option) => result.push(internationalizeOption(option, intl)));
   return result;
}

class SponsorAffinityAvailabilitySelectionPanel extends Component {

   constructor(props) {
      super(props);

      this.values = [];
   }

   componentDidMount() {
      this.props.load();
   }

   componentWillReceiveProps(props) {
      this.values = [];
      props.source.forEach((set) => this.values.push({ name: set.name, options: internationalizeOptions(set.options, props.intl) }));
   }

   render() {
      return (
         <Box>
            {this.values.map((element, i) => <Combo index={i} key={i} source={element.options} onChange={this.props.action} />)}
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

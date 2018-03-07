import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import Listing from 'components/Listing';

import { connect } from 'react-redux';

import { selectChosenAffinities } from 'builder/affinities/selectors';

import affinityMessages from 'i18n/affinity';

class SponsorAffinitiesList extends Component {

   render() {
      const affinities = this.props.source.map((affinity) => {
         const aff = this.props.intl.formatMessage(affinityMessages[affinity]);
         return aff;
      });

      return (
         <Listing source={affinities} />
      );
   }

}

SponsorAffinitiesList.propTypes = {
   source: PropTypes.array.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: selectChosenAffinities(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinitiesList));

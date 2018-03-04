import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import { injectIntl } from 'react-intl';

import Value from 'grommet/components/Value';

import { selectTotalCost } from 'builder/sponsors/selectors';

import teamMessages from 'i18n/team';

const SponsorTotalCost = (props) => <Value value={props.totalCost} label={props.intl.formatMessage(teamMessages.totalCost)} />;

SponsorTotalCost.propTypes = {
   totalCost: PropTypes.number.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      totalCost: selectTotalCost(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTotalCost));

import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import { injectIntl } from 'react-intl';

import Value from 'grommet/components/Value';

import { selectRank } from 'builder/sponsors/selectors';

import teamMessages from 'i18n/team';

const SponsorRankValue = (props) => <Value value={props.value} label={props.intl.formatMessage(teamMessages.rank)} />;

SponsorRankValue.propTypes = {
   value: PropTypes.number.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: selectRank(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorRankValue));

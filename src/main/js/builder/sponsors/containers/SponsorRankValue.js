import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

import { selectRank } from 'builder/sponsors/selectors';

const SponsorRankValue = (props) => <Value value={props.rank} label='rank' />;

SponsorRankValue.propTypes = {
   rank: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      rank: selectRank(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorRankValue);

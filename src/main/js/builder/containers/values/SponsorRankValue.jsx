import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

const SponsorRankValue = (props) => {
   return (
      <Value value={props.rank} label='rank' />
   );
};

SponsorRankValue.propTypes = {
   rank: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      rank: state.builder.sponsor.rank
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorRankValue);

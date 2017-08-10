import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

const WagerValue = (props) => {
   return (
      <Value value={props.rank} label='wager' />
   );
};

WagerValue.propTypes = {
   rank: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      rank: state.builder.sponsor.wagers
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(WagerValue);

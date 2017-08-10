import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

const CheerleadersValue = (props) => {
   return (
      <Value value={props.cheers} label='cheerleaders' />
   );
};

CheerleadersValue.propTypes = {
   cheers: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      cheers: state.builder.sponsor.cheerleaders
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CheerleadersValue);

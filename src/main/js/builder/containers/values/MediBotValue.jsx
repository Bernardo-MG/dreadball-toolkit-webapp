import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

const MediBotValue = (props) => <Value value={props.bots} label='medibot' />;

MediBotValue.propTypes = {
   bots: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      bots: state.builder.sponsor.mediBots
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(MediBotValue);

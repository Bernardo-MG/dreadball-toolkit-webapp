import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

import { selectTotalCost } from 'builder/sponsors/selectors';

const SponsorTotalCost = (props) => <Value value={props.totalCost} label='totalCost' />;

SponsorTotalCost.propTypes = {
   totalCost: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      totalCost: selectTotalCost(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTotalCost);

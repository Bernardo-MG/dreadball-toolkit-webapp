import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

import { selectTeamValue } from 'builder/sponsors/selectors';

const SponsorTeamValue = (props) => <Value value={props.teamValue} label='teamValue' />;

SponsorTeamValue.propTypes = {
   teamValue: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      teamValue: selectTeamValue(state)
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamValue);

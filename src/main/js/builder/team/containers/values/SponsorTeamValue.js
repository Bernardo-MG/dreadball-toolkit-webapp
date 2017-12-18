import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

const SponsorTeamValue = (props) => <Value value={props.teamValue} label='teamValue' />;

SponsorTeamValue.propTypes = {
   teamValue: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      teamValue: state.builder.sponsor.teamValue
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamValue);

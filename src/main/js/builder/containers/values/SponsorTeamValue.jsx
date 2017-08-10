import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';

import Value from 'grommet/components/Value';

const SponsorTeamValue = (props) => {
   return (
      <Value value={props.teamValue} label='teamValue' />
   );
};

SponsorTeamValue.propTypes = {
   teamValue: PropTypes.number.isRequired
};

const mapStateToProps = (state) => {
   return {
      teamValue: state.builder.sponsor.teamValue
   };
};

const mapDispatchToProps = (dispatch) => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorTeamValue);

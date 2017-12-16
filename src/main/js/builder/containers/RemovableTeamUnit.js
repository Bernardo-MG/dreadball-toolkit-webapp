import React from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';

import { connect } from 'react-redux';

import RemoveUnitButton from 'builder/containers/button/RemoveUnitButton';


const RemovableTeamUnit = (props) =>
   <Box>{props.unit} <RemoveUnitButton unit={props.unit} /></Box>;

RemovableTeamUnit.propTypes = {
   unit: PropTypes.string.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: state.builder.sponsor.affinities
   };
};

const mapDispatchToProps = () => {
   return {};
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(RemovableTeamUnit);

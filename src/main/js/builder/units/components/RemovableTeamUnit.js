import React from 'react';

import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';

import RemoveUnitButton from 'builder/units/containers/buttons/RemoveUnitButton';

const RemovableTeamUnit = (props) =>
   <Box>{props.unit} <RemoveUnitButton unit={props.unit} /></Box>;

RemovableTeamUnit.propTypes = {
   unit: PropTypes.string.isRequired
};

export default RemovableTeamUnit;

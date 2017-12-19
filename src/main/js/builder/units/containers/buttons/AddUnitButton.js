import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';

import { addTeamUnit } from 'builder/units/actions';

import AddIcon from 'grommet/components/icons/base/AddCircle';

const AddUnitButton = (props) =>
   <Button onClick={() => props.action(props.unit)} icon={<AddIcon/>} />;

AddUnitButton.propTypes = {
   unit: PropTypes.string.isRequired,
   action: PropTypes.func.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(addTeamUnit, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AddUnitButton);

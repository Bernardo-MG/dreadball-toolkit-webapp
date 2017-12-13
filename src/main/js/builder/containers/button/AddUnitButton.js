import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';

import * as actions from 'builder/actions';

import AddIcon from 'grommet/components/icons/base/AddCircle';

const AddUnitButton = (props) =>
   <Button onClick={() => props.action(props.unit)} icon={<AddIcon/>} />;

AddUnitButton.propTypes = {
   unit: PropTypes.string.isRequired,
   action: PropTypes.object.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(actions.addTeamUnit, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AddUnitButton);

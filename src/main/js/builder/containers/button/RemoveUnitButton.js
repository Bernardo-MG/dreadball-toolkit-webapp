import React from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';

import { removeTeamUnit } from 'builder/actions';

import SubtractIcon from 'grommet/components/icons/base/SubtractCircle';

const RemoveUnitButton = (props) =>
   <Button onClick={() => props.action(props.unit)} icon={<SubtractIcon/>} />;

RemoveUnitButton.propTypes = {
   unit: PropTypes.string.isRequired,
   action: PropTypes.object.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(removeTeamUnit, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(RemoveUnitButton);

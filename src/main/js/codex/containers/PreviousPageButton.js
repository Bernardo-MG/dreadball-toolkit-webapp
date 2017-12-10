import React from 'react';

import PropTypes from 'prop-types';

import * as actions from 'models/actions/unit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';
import BackIcon from 'grommet/components/icons/base/CaretBack';

const PreviousPageButton = (props) =>
   <Button onClick={props.action} icon={<BackIcon/>} />;

PreviousPageButton.propTypes = {
   action: PropTypes.object.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(actions.movePrevPage, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(PreviousPageButton);

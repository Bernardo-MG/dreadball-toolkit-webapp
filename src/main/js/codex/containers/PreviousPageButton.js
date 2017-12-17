import React from 'react';

import PropTypes from 'prop-types';

import { movePrevPage } from 'models/actions/unit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';
import BackIcon from 'grommet/components/icons/base/CaretBack';

const PreviousPageButton = (props) =>
   <Button onClick={props.action} icon={<BackIcon/>} />;

PreviousPageButton.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(movePrevPage, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(PreviousPageButton);

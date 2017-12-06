import React from 'react';

import PropTypes from 'prop-types';

import * as actions from 'models/actions/unit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';
import NextIcon from 'grommet/components/icons/base/CaretNext';

const NextPageButton = (props) =>
   <Button onClick={props.actions.moveNextPage} icon={<NextIcon/>} />;

NextPageButton.propTypes = {
   actions: PropTypes.object.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(NextPageButton);

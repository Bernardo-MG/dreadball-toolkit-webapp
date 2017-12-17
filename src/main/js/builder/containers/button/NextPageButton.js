import React from 'react';

import PropTypes from 'prop-types';

import { moveNextPage } from 'models/actions/sponsorUnit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import Button from 'grommet/components/Button';
import NextIcon from 'grommet/components/icons/base/CaretNext';

const NextPageButton = (props) =>
   <Button onClick={props.action} icon={<NextIcon/>} />;

NextPageButton.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = () => {
   return {};
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(moveNextPage, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(NextPageButton);

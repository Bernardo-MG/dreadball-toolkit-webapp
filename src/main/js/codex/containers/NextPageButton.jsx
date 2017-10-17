import React from 'react';

import PropTypes from 'prop-types';

import * as actions from 'models/actions/unit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import NextIcon from 'grommet/components/icons/base/CaretNext';

import PageChangeButton from 'components/PageChangeButton';

const NextPageButton = (props) =>
   <PageChangeButton changePage={props.actions.moveNextPage} icon={<NextIcon/>} />;

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

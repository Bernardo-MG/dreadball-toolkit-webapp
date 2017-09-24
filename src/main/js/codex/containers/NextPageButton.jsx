import React from 'react';

import PropTypes from 'prop-types';

import * as actions from 'requests/actions/unit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { nextPage } from 'pagination/move';

import NextIcon from 'grommet/components/icons/base/CaretNext';

import PageChangeButton from 'components/PageChangeButton';

const NextPageButton = (props) =>
   <PageChangeButton changePage={nextPage} fetch={props.actions.fetch} page={props.page} endingPage={props.lastPage} icon={<NextIcon/>} />;

NextPageButton.propTypes = {
   actions: PropTypes.object.isRequired,
   page: PropTypes.number.isRequired,
   lastPage: PropTypes.bool
};

const mapStateToProps = (state) => {
   return {
      lastPage: state.pagination.units.last,
      page: state.pagination.units.page
   };
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

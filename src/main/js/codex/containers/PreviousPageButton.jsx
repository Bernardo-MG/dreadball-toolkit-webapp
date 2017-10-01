import React from 'react';

import PropTypes from 'prop-types';

import * as actions from 'models/actions/unit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { previousPage } from 'api/pagination/move';

import BackIcon from 'grommet/components/icons/base/CaretBack';

import PageChangeButton from 'components/PageChangeButton';

const PreviousPageButton = (props) =>
   <PageChangeButton changePage={previousPage} fetch={props.actions.fetch} page={props.page} endingPage={props.firstPage} icon={<BackIcon/>} />;

PreviousPageButton.propTypes = {
   actions: PropTypes.object.isRequired,
   page: PropTypes.number.isRequired,
   firstPage: PropTypes.bool,
   label: PropTypes.string
};

const mapStateToProps = (state) => {
   return {
      firstPage: state.pagination.units.first,
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
)(PreviousPageButton);

import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import * as actions from 'requests/actions/unit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { nextPage } from 'pagination/move';

import PageChangeButton from 'components/PageChangeButton';

import buttonMessages from 'i18n/button';

const NextPageButton = (props) =>
   <PageChangeButton changePage={nextPage} fetch={props.actions.fetch} page={props.page} endingPage={props.lastPage}
      label={props.intl.formatMessage(buttonMessages.next)} />;

NextPageButton.propTypes = {
   actions: PropTypes.object.isRequired,
   page: PropTypes.number.isRequired,
   lastPage: PropTypes.bool,
   intl: PropTypes.object.isRequired
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

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(NextPageButton));

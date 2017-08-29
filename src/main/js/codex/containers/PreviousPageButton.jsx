import React from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import * as actions from 'requests/actions/unit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { previousPage } from 'pagination/move';

import PageChangeButton from 'components/PageChangeButton';

import buttonMessages from 'i18n/button';

const PreviousPageButton = (props) =>
   <PageChangeButton changePage={previousPage} fetch={props.actions.fetch} page={props.page} endingPage={props.firstPage}
      label={props.intl.formatMessage(buttonMessages.previous)} />;

PreviousPageButton.propTypes = {
   actions: PropTypes.object.isRequired,
   page: PropTypes.number.isRequired,
   firstPage: PropTypes.bool,
   label: PropTypes.string,
   intl: PropTypes.object.isRequired
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

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(PreviousPageButton));

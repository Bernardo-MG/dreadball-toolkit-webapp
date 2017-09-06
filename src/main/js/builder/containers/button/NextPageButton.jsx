import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import * as actions from 'requests/actions/sponsorUnit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { nextPage } from 'pagination/move';

import PageChangeButton from 'components/PageChangeButton';

import buttonMessages from 'i18n/button';

class NextPageButton extends Component {

   fetch = (page = 0, orderBy = 'name', direction = 'ASC') => {
      this.props.actions.fetch(this.props.affinities, page, orderBy, direction);
   };

   render() {
      return (
         <PageChangeButton changePage={nextPage} fetch={this.fetch} page={this.props.page} endingPage={this.props.lastPage}
            label={this.props.intl.formatMessage(buttonMessages.next)} />
      );
   }
}

NextPageButton.propTypes = {
   affinities: PropTypes.array.isRequired,
   actions: PropTypes.object.isRequired,
   page: PropTypes.number.isRequired,
   lastPage: PropTypes.bool,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      affinities: state.builder.sponsor.affinities,
      lastPage: state.pagination.ratedUnits.last,
      page: state.pagination.ratedUnits.page
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

import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import * as actions from 'models/actions/sponsorUnit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import { previousPage } from 'api/pagination/move';

import PageChangeButton from 'components/PageChangeButton';

import buttonMessages from 'i18n/button';

class PreviousPageButton extends Component {

   fetch = (page = 0, orderBy = 'name', direction = 'ASC') => {
      this.props.actions.fetch(this.props.affinities, page, orderBy, direction);
   };

   render() {
      return (
         <PageChangeButton changePage={previousPage} fetch={this.fetch} page={this.props.page} endingPage={this.props.firstPage}
            label={this.props.intl.formatMessage(buttonMessages.previous)} />
      );
   }
}

PreviousPageButton.propTypes = {
   affinities: PropTypes.array.isRequired,
   actions: PropTypes.object.isRequired,
   page: PropTypes.number.isRequired,
   firstPage: PropTypes.bool,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      affinities: state.builder.sponsor.affinities,
      firstPage: state.pagination.ratedUnits.first,
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
)(PreviousPageButton));

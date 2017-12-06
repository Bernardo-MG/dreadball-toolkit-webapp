import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import * as actions from 'models/actions/sponsorUnit';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import PageChangeButton from 'components/PageChangeButton';

import NextIcon from 'grommet/components/icons/base/CaretNext';

class NextPageButton extends Component {

   fetch = (page = 0, orderBy = 'name', direction = 'ASC') => {
      this.props.actions.fetch(this.props.affinities, page, orderBy, direction);
   };

   render() {
      return (
         <PageChangeButton changePage={this.props.actions.moveNextPage} icon={<NextIcon/>} />
      );
   }
}

NextPageButton.propTypes = {
   affinities: PropTypes.array.isRequired,
   actions: PropTypes.object.isRequired,
   intl: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      affinities: state.builder.sponsor.affinities
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

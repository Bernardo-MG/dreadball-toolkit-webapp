import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { injectIntl } from 'react-intl';

import * as actions from 'requests/actions/unit';
import { bindActionCreators } from 'redux';
import Button from 'grommet/components/Button';
import { connect } from 'react-redux';
import { nextPage } from 'pagination/move';

import buttonMessages from 'i18n/button';

class NextPageButton extends Component {

   callApi = () => {
      nextPage(this.props.actions.fetch, this.props.page, this.props.lastPage);
   };

   constructor(props) {
      super(props);

      if (this.props.label) {
         this.label = this.props.label;
      } else {
         this.label = props.intl.formatMessage(buttonMessages.next);
      }
   }

   render() {
      return (
         <Button onClick={this.callApi} label={this.label}/>
      );
   }
}

NextPageButton.propTypes = {
   actions: PropTypes.object.isRequired,
   page: PropTypes.number.isRequired,
   lastPage: PropTypes.bool,
   label: PropTypes.string,
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

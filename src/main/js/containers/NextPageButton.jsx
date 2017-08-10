import React, { Component } from 'react';

import PropTypes from 'prop-types';

import * as actions from 'requests/actions/unit';
import { bindActionCreators } from 'redux';
import Button from 'grommet/components/Button';
import { connect } from 'react-redux';
import { nextPage } from 'pagination/move';
import { injectIntl } from 'react-intl';

class NextPageButton extends Component {

   callApi = () => {
      nextPage(this.props.actions.fetch, this.props.page, this.props.lastPage);
   };

   render() {
      return (
         <Button onClick={this.callApi} label={this.props.label}/>
      );
   }
}

NextPageButton.propTypes = {
   actions: PropTypes.object.isRequired,
   page: PropTypes.number.isRequired,
   lastPage: PropTypes.number.isRequired,
   label: PropTypes.string.isRequired
};

const mapStateToProps = (state) => ({
   lastPage: state.pagination.units.last,
   page: state.pagination.units.page,
   totalPages: state.pagination.units.totalPages
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(actions, dispatch)
});

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(NextPageButton));

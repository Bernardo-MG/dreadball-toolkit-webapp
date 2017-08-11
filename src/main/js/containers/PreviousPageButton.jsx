import React, { Component } from 'react';

import PropTypes from 'prop-types';

import * as actions from 'requests/actions/unit';
import { bindActionCreators } from 'redux';
import Button from 'grommet/components/Button';
import { connect } from 'react-redux';
import { previousPage } from 'pagination/move';

class PreviousPageButton extends Component {

   callApi = () => {
      previousPage(this.props.actions.fetch, this.props.page, this.props.firstPage);
   };

   render() {
      return (
         <Button onClick={this.callApi} label={this.props.label}/>
      );
   }
}

PreviousPageButton.propTypes = {
   actions: PropTypes.object.isRequired,
   page: PropTypes.number.isRequired,
   firstPage: PropTypes.number.isRequired,
   label: PropTypes.string.isRequired
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

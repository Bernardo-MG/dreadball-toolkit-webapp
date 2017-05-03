import React, { Component } from 'react'
import * as actions from 'requests/actions/unit';
import { bindActionCreators } from 'redux';
import Button from 'grommet/components/Button';
import { connect } from 'react-redux';
import { nextPage } from 'pagination/utils';

class NextPageButton extends Component {

   callApi = () => {
      nextPage(this.props.actions.fetch, this.props.page, this.props.totalPages)
   };
   
   render() {
      return (
         <Button onClick={this.callApi} label={this.props.label}/>
      )
   }
}

const mapStateToProps = (state) => ({
   page: state.pagination.units.page,
   totalPages: state.pagination.units.totalPages
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(NextPageButton);

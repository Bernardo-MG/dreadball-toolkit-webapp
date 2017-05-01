import React, { Component } from 'react'
import * as actions from 'actions/request/unit';
import { bindActionCreators } from 'redux';
import Button from 'grommet/components/Button';
import { connect } from 'react-redux';
import { previousPage } from 'pagination/utils';

class PreviousPageButton extends Component {

   callApi = () => {
      previousPage(this.props.actions.fetch, this.props.page)
   };
   
   render() {
      return (
         <Button onClick={this.callApi} label={this.props.label}/>
      )
   }
}

const mapStateToProps = (state) => ({
   page: state.pagination.units.page
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(PreviousPageButton);

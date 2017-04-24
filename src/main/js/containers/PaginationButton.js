import React, { Component } from 'react'
import * as actions from 'actions/request/unit';
import { bindActionCreators } from 'redux';
import { Button } from 'react-toolbox/lib/button';
import { connect } from 'react-redux';

class PaginationButton extends Component {

   callApi = () => {
      this.props.actions.fetch(this.props.page + 1);
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
)(PaginationButton);

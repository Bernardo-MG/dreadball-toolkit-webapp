import React, { Component } from 'react'
import * as actions from 'requests/actions/unit';
import { bindActionCreators } from 'redux';
import Button from 'grommet/components/Button';
import { connect } from 'react-redux';
import { previousPage } from 'pagination/utils';

class PreviousPageButton extends Component {

   callApi = () => {
      previousPage(this.props.actions.fetch, this.props.page, this.props.firstPage)
   };
   
   render() {
      return (
         <Button onClick={this.callApi} label={this.props.label}/>
      )
   }
}

const mapStateToProps = (state) => ({
   firstPage: state.pagination.units.first,
   page: state.pagination.units.page
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(PreviousPageButton);

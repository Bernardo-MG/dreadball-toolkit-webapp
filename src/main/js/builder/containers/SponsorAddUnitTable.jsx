import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as actions from 'requests/actions/sponsorUnit';
import { ratedUnits } from 'models/selectors';
import AddUnitTable from 'builder/components/AddUnitTable';

class SponsorAddUnitTable extends Component {

   componentDidMount() {
      this.props.actions.fetch();
   }

   render() {
      return (
         <AddUnitTable source={this.props.source}/>
      );
   }
}

const mapStateToProps = (state) => {
   return {
      source: ratedUnits(state)
   }
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(actions, dispatch)
   }
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAddUnitTable);

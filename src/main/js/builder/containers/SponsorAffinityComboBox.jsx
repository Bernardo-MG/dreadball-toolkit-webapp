import React, { Component } from 'react';
import Select from 'grommet/components/Select';
import SponsorAffinitySelect from 'builder/components/SponsorAffinitySelect';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import * as Actions from 'builder/actions';

class SponsorAffinityComboBox extends Component {

   render() {
      return (
         <SponsorAffinitySelect source={this.props.source} handleSelection={this.props.actions.chooseSponsorAffinity} />
      );
   }
}

const mapStateToProps = (state) => ({
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorAffinityComboBox);

import React, { Component } from 'react'
import ComboPanel from '../components/ComboPanel';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as Actions from '../actions/dbxBuilder';
import { injectIntl } from 'react-intl';

class AffinityGroupsComboPanel extends Component {
   
   componentDidMount() {
      this.props.actions.fetchSponsorAffinityGroupAvailabilities(this.props.intl);
   }
   
   render() {
      return (
         <ComboPanel source={this.props.source} />
      )
   }
}

const mapStateToProps = (state) => ({
   source: state.dbxBuilder.sponsorAffinityGroupAvailabilities
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(Actions, dispatch)
});

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(AffinityGroupsComboPanel));

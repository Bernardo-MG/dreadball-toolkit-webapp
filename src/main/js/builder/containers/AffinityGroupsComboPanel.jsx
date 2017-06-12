import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as actions from 'requests/actions/sponsorAffAva';
import { sponsorAffAvas } from 'models/selectors';
import { avasToMap } from 'builder/utils';
import SponsorAffinitySelectField from 'builder/components/SponsorAffinitySelectField';

class AffinityGroupsComboPanel extends Component {

   componentDidMount() {
      this.props.actions.fetch();
   }

   render() {
      return (
         <SponsorAffinitySelectField source={this.props.source} />
      );
   }
}

const mapStateToProps = state => ({
   source: avasToMap(sponsorAffAvas(state))
});

const mapDispatchToProps = dispatch => ({
   actions: bindActionCreators(actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AffinityGroupsComboPanel);

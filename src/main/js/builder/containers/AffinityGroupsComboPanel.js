import React, { Component } from 'react';

import PropTypes from 'prop-types';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { fetch } from 'models/actions/sponsorAffAva';

import { selectSponsorAffAvas } from 'models/selectors';

import { avasToMap } from 'builder/models/utils';
import SponsorAffinitySelectField from 'builder/components/SponsorAffinitySelectField';

class AffinityGroupsComboPanel extends Component {

   componentDidMount() {
      this.props.action();
   }

   render() {
      return (
         <SponsorAffinitySelectField source={this.props.source} />
      );
   }

}

AffinityGroupsComboPanel.propTypes = {
   action: PropTypes.func.isRequired,
   source: PropTypes.array.isRequired
};

const mapStateToProps = (state) => {
   return {
      source: avasToMap(selectSponsorAffAvas(state))
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(fetch, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AffinityGroupsComboPanel);

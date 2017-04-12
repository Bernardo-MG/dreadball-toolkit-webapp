import React, { Component } from 'react'
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as actions from 'actions/request/sponsorAffAva';
import { injectIntl } from 'react-intl';
import SponsorAffinityComboBox from 'containers/SponsorAffinityComboBox';

const ComboPanel = (props) => {
   if (props.source) {
      return (
         <div>
            {props.source.map(function(element, i) {
               return (
                  <SponsorAffinityComboBox index={i} key={i} source={element} />
               );
            })}
         </div>
      );
   } else {
      return (
         <div/>
      );
   }
};

class AffinityGroupsComboPanel extends Component {
   
   componentDidMount() {
      this.props.actions.fetch(this.props.intl);
   }
   
   render() {
      return (
         <ComboPanel source={this.props.source} />
      )
   }
}

const mapStateToProps = (state) => ({
   source: state.dbxBuilder.sponsorAffinityGroupAvailabilities.availabilities
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(actions, dispatch)
});

export default injectIntl(connect(
   mapStateToProps,
   mapDispatchToProps
)(AffinityGroupsComboPanel));

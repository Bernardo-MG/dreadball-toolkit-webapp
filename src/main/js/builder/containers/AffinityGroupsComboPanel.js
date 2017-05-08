import React, { Component } from 'react'
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as actions from 'requests/actions/sponsorAffAva';
import SponsorAffinityComboBox from 'builder/containers/SponsorAffinityComboBox';
import { sponsorAffAvas } from 'models/selectors';
import { avasToMap } from 'utils';

const ComboPanel = (props) => {
   if (props.source.length) {
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
      this.props.actions.fetch();
   }
   
   render() {
      return (
         <ComboPanel source={this.props.source} />
      )
   }
}

const mapStateToProps = (state) => ({
   source: avasToMap(sponsorAffAvas(state))
});

const mapDispatchToProps = (dispatch) => ({
   actions: bindActionCreators(actions, dispatch)
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(AffinityGroupsComboPanel);

import React, { Component } from 'react'
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as actions from 'requests/actions/sponsorAffAva';
import SponsorAffinityComboBox from 'containers/SponsorAffinityComboBox';
import { sponsorAffAvas } from 'models/selectors';

const avasToMap = (avas) => {
   var result;
   
   result = avas.map(function(ava) {
      return avaToMap(ava);
   });
   
   return result;
}

const avaToMap = (ava) => {
   var result = ava.affinityGroups.map(function(affinity) {
      return {
         label: affinity,
         value: affinity
      }
   });
   
   if(ava.includingRankIncrease){
      result.push({
         label: 'rank_increase',
         value: 'rank_increase'
      });
   }
   
   return result;
}

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

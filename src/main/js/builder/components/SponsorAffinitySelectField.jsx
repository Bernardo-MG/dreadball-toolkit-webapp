import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as actions from 'requests/actions/sponsorAffAva';
import { sponsorAffAvas } from 'models/selectors';
import { avasToMap } from 'builder/utils';
import SponsorAffinityComboBox from 'builder/containers/SponsorAffinityComboBox';

class SponsorAffinitySelectField extends Component {

   render() {
      return (
         <div>
            {this.props.source.map((element, i) => {
               return (
                  <SponsorAffinityComboBox index={i} key={i} source={element} />
               );
            })}
         </div>
      );
   }
}

export default SponsorAffinitySelectField;

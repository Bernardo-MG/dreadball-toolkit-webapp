import React from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as actions from 'requests/actions/sponsorAffAva';
import { sponsorAffAvas } from 'models/selectors';
import { avasToMap } from 'builder/utils';
import SponsorAffinityComboBox from 'builder/containers/SponsorAffinityComboBox';

const SponsorAffinitySelectField = (props) => {
   return (
      <div>
         {props.source.map((element, i) => {
            return (
               <SponsorAffinityComboBox index={i} key={i} source={element} />
            );
         })}
      </div>
   );
}

export default SponsorAffinitySelectField;

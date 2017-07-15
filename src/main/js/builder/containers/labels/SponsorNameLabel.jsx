import React from 'react';
import { connect } from 'react-redux';

import Label from 'grommet/components/Label';

const SponsorNameLabel = (props) => {
   return (
      <Label>
         { props.sponsorName }
      </Label>
   );
};

const mapStateToProps = (state) => {
   return {
      sponsorName: state.builder.sponsor.sponsorName
   }
};

const mapDispatchToProps = (dispatch) => ({
});

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorNameLabel);

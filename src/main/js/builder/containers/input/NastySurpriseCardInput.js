import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { updateSponsorNastySurpriseCard } from 'builder/actions';

import SponsorBoundNumberInput from 'builder/containers/input/SponsorBoundNumberInput';

const NastySurpriseCardInput = (props) =>
   <SponsorBoundNumberInput {...props}
      handleChange={props.action}
      updateSponsor={(value, sponsor) => {
         const result = Object.assign({}, sponsor);
         result.nastySurpriseCards = value;
         return result;
      }} />;

NastySurpriseCardInput.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.nastySurpriseCards
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(updateSponsorNastySurpriseCard, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(NastySurpriseCardInput);

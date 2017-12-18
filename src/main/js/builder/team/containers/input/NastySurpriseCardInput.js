import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setNastySurpriseCard } from 'builder/actions';

import SponsorBoundNumberInput from 'builder/team/containers/input/SponsorBoundNumberInput';

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
      action: bindActionCreators(setNastySurpriseCard, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(NastySurpriseCardInput);

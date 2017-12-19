import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setSpecialMoveCard } from 'builder/assets/actions';

import SponsorBoundNumberInput from 'builder/assets/containers/SponsorBoundNumberInput';

const SpecialMoveCardInput = (props) =>
   <SponsorBoundNumberInput {...props}
      handleChange={props.action}
      updateSponsor={(value, sponsor) => {
         const result = Object.assign({}, sponsor);
         result.specialMoveCards = value;
         return result;
      }} />;

SpecialMoveCardInput.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.specialMoveCards
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(setSpecialMoveCard, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SpecialMoveCardInput);

import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { updateSponsorWager } from 'builder/actions';

import SponsorBoundNumberInput from 'builder/containers/input/SponsorBoundNumberInput';

const WagerInput = (props) =>
   <SponsorBoundNumberInput {...props}
      handleChange={props.action}
      updateSponsor={(value, sponsor) => {
         const result = Object.assign({}, sponsor);
         result.wagers = value;
         return result;
      }} />;

WagerInput.propTypes = {
   action: PropTypes.func.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.wagers
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(updateSponsorWager, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(WagerInput);

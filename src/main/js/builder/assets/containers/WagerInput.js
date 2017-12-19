import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { setWager } from 'builder/assets/actions';

import SponsorBoundNumberInput from 'builder/assets/containers/SponsorBoundNumberInput';

import { specialMoveCardsSelector } from 'builder/assets/selectors';

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
      value: specialMoveCardsSelector(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(setWager, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(WagerInput);

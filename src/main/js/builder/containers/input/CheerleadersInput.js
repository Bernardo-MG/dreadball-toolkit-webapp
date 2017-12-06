import React from 'react';

import PropTypes from 'prop-types';

import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import * as Actions from 'builder/actions';

import SponsorBoundNumberInput from 'builder/containers/input/SponsorBoundNumberInput';

const CheerleadersInput = (props) =>
   <SponsorBoundNumberInput {...props}
      handleChange={props.actions.updateSponsorCheerleaders}
      updateSponsor={(value, sponsor) => {
         const result = Object.assign({}, sponsor);
         result.cheerleaders = value;
         return result;
      }} />;

CheerleadersInput.propTypes = {
   actions: PropTypes.object.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: state.builder.sponsor.cheerleaders
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      actions: bindActionCreators(Actions, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(CheerleadersInput);

import React from 'react';

import PropTypes from 'prop-types';

import FormField from 'grommet/components/FormField';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { setSponsorName } from 'builder/actions';

import { selectSponsorName } from 'builder/sponsors/selectors';

const SponsorNameInput = (props) =>
   <FormField label={props.label}>
      <input id='sponsor_name' name='sponsor_name' type='text' value={props.value} onChange={(event) => props.action(event.target.value)}/>
   </FormField>;

SponsorNameInput.propTypes = {
   action: PropTypes.func.isRequired,
   label: PropTypes.string.isRequired,
   value: PropTypes.string.isRequired
};

const mapStateToProps = (state) => {
   return {
      value: selectSponsorName(state)
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(setSponsorName, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorNameInput);

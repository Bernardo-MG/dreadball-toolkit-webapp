import React, { Component } from 'react';

import PropTypes from 'prop-types';

import FormField from 'grommet/components/FormField';

import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';

import { updateSponsorName } from 'builder/actions';

class SponsorNameInput extends Component {

   update;

   updateValue = (event) => {
      this.update(event.target.value);
   };

   constructor(props) {
      super(props);

      this.update = props.action;
   }

   render() {
      return (
         <FormField label='sponsor_name'>
            <input id='sponsor_name' name='sponsor_name' type='text' value={this.props.sponsorName} onChange={this.updateValue}/>
         </FormField>
      );
   }
}

SponsorNameInput.propTypes = {
   action: PropTypes.func.isRequired,
   sponsorName: PropTypes.string.isRequired
};

const mapStateToProps = (state) => {
   return {
      sponsorName: state.builder.sponsor.sponsorName
   };
};

const mapDispatchToProps = (dispatch) => {
   return {
      action: bindActionCreators(updateSponsorName, dispatch)
   };
};

export default connect(
   mapStateToProps,
   mapDispatchToProps
)(SponsorNameInput);
